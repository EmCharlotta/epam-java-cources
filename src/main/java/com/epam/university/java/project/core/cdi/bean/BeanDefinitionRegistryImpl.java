package com.epam.university.java.project.core.cdi.bean;


import java.util.HashMap;
import java.util.Map;

public class BeanDefinitionRegistryImpl implements BeanDefinitionRegistry {
    private final Map<String, BeanDefinition> registry = new HashMap<>();

    @Override
    public void addBeanDefinition(BeanDefinition definition) {
        registry.put(definition.getId(), definition);
        try {
            Class<?> clazz = Class.forName(definition.getClassName());
            for (Class<?> classInterface : clazz.getInterfaces()) {
                if (classInterface != null) {
                    String tempName = classInterface.getSimpleName();
                    String beanName = tempName.substring(0, 1)
                            .toLowerCase() + tempName.substring(1);
                    registry.put(beanName, definition);
                }
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public BeanDefinition getBeanDefinition(String beanId) {
        return registry.get(beanId);
    }
}
