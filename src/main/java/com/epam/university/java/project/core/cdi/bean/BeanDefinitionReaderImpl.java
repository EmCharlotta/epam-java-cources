package com.epam.university.java.project.core.cdi.bean;

import com.epam.university.java.project.core.cdi.io.Resource;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Collection;

public class BeanDefinitionReaderImpl implements BeanDefinitionReader {
    private final BeanDefinitionRegistry beanDefinitionRegistry;

    public BeanDefinitionReaderImpl(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        if (resource == null) {
            System.err.println("Resource is null");
            throw new NullPointerException("Resource is null");
        }
        int numberOfLoadedBeans = 0;
        try {
            JAXBContext jc = JAXBContext.newInstance(BeansRoot.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            BeansRoot beans = (BeansRoot) unmarshaller.unmarshal(resource.getFile());
            Collection<BeanDefinition> beanDefinitionList = beans.getCollectionOfBeans();

            if (beanDefinitionList.isEmpty()) {
                System.err.println("Bean definition collection is empty");
                throw new RuntimeException("Bean definition collection is empty");
            }

            for (BeanDefinition bdf : beanDefinitionList
            ) {
                beanDefinitionRegistry.addBeanDefinition(bdf);
                numberOfLoadedBeans++;
            }

            return numberOfLoadedBeans;

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return numberOfLoadedBeans;
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        if (resources == null) {
            System.err.println("Resources are null");
            throw new NullPointerException("Resources are null");
        }
        int numberOfLoadedBeanDefinitions = 0;
        for (Resource resource : resources
        ) {
            numberOfLoadedBeanDefinitions += loadBeanDefinitions(resource);
        }
        return numberOfLoadedBeanDefinitions;
    }
}
