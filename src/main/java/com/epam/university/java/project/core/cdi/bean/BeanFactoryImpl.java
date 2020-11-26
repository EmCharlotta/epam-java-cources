package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.structure.ListDefinition;
import com.epam.university.java.project.core.cdi.structure.MapDefinition;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BeanFactoryImpl implements BeanFactory {
    private final BeanDefinitionRegistry beanDefinitionRegistry;
    private final Map<BeanDefinition, Object> collectionOfSingletons = new HashMap<>();

    public BeanFactoryImpl(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(Class<T> beanClass) {
        String tempName = beanClass.getSimpleName();
        String beanName = tempName.substring(0, 1).toLowerCase() + tempName.substring(1);
        return (T) getBean(beanName);
    }

    @Override
    public Object getBean(String beanName) {
        return getBean(beanDefinitionRegistry.getBeanDefinition(beanName));
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return (T) getBean(beanName);
    }

    /**
     * Constructing classes based on its definitions.
     */
    @SuppressWarnings("unchecked")
    public <T> T getBean(BeanDefinition definition) {
        // if no properties and scope is "prototype"
        if (definition.getProperties() == null
                && definition.getScope() != null
                && definition.getScope().equals("prototype")) {
            T instance;
            Class<T> clazz;
            try {
                clazz = (Class<T>) Class.forName(definition.getClassName());
                instance = clazz.getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                throw new RuntimeException();
            }
            return instance;
        }

        Predicate<String> isNullOrBlank = x -> x == null || x.isBlank();

        // check for wrong properties if exist
        if (definition.getProperties() != null) {
            if (definition.getProperties().stream()
                    .anyMatch(n -> isNullOrBlank.test(n.getValue())
                            && isNullOrBlank.test(n.getRef())
                            && n.getData() == null)
            ) {
                System.err.println("Property doesn't have value,"
                        + " ref or data (list or map)");
                throw new RuntimeException("Property doesn't have value, "
                        + "ref or data (list or map)");
            }
        }

        try {
            T instance;
            Class<T> clazz = (Class<T>) Class.forName(definition.getClassName());

            // if no properties and no scope
            if (definition.getScope() == null
                    && definition.getProperties() == null) {
                instance = clazz.getDeclaredConstructor().newInstance();
                return instance;
            }

            // if scope is "singleton" - take object from map or put into map
            if (definition.getScope() != null
                    && definition.getScope().equals("singleton")
                    && collectionOfSingletons.containsKey(definition)) {
                instance = (T) collectionOfSingletons.get(definition);
                return instance;
            } else {
                instance = clazz.getDeclaredConstructor().newInstance();
                // if no properties and no scope
                if (definition.getProperties() == null
                        && definition.getScope() == null
                ) {
                    return instance;
                }
                // if scope is "singleton"
                if (definition.getScope() != null && definition.getScope().equals("singleton")) {
                    collectionOfSingletons.put(definition, instance);
                }
            }
            // if our singleton has no properties -> return it from map
            if (definition.getProperties() == null) {
                return (T) collectionOfSingletons.get(definition);
            }

            for (BeanPropertyDefinition property : definition.getProperties()) {
                Field beanField = clazz.getDeclaredField(property.getName());
                beanField.setAccessible(true);

                if (!isNullOrBlank.test(property.getRef())) {
                    Object dependency = getBean(property.getRef());
                    beanField.set(instance, dependency);
                }

                if (!isNullOrBlank.test(property.getValue())) {
                    try {
                        beanField.set(instance, Integer.parseInt(property.getValue()));
                    } catch (Exception e) {
                        beanField.set(instance, property.getValue());
                    }
                }

                // if current property has no data, we move to the next property
                if (property.getData() == null) {
                    continue;
                }

                if (property.getData() instanceof ListDefinition) {
                    ListDefinition listDefinition = (ListDefinition) property.getData();
                    Collection<String> items = listDefinition.getValues()
                            .stream()
                            .map(ListDefinition.ListItemDefinition::getValue)
                            .collect(Collectors.toList());
                    beanField.set(instance, items);
                }

                if (property.getData() instanceof MapDefinition) {
                    MapDefinition mapDefinition = (MapDefinition) property.getData();
                    Map<String, Object> itemMap = new HashMap<>();
                    for (MapDefinition.MapEntryDefinition entryDefinition
                            : mapDefinition.getEntries()) {
                        // if there is value and ref in one property
                        if (!isNullOrBlank.test(entryDefinition.getValue())
                                && !isNullOrBlank.test(entryDefinition.getRef())) {
                            throw new RuntimeException("Key has to be associated either"
                                    + " with value or ref");
                        }

                        if (!isNullOrBlank.test(entryDefinition.getValue())) {
                            itemMap.put(entryDefinition.getKey(), entryDefinition.getValue());
                        } else if (!isNullOrBlank.test(entryDefinition.getRef())) {
                            Object dependency = getBean(entryDefinition.getRef());
                            itemMap.put(entryDefinition.getKey(), dependency);
                        }
                    }
                    beanField.set(instance, itemMap);
                }
            }
            return instance;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
