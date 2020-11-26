package com.epam.university.java.project.core.cdi.context;

import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReader;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionReaderImpl;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistry;
import com.epam.university.java.project.core.cdi.bean.BeanDefinitionRegistryImpl;
import com.epam.university.java.project.core.cdi.bean.BeanFactory;
import com.epam.university.java.project.core.cdi.bean.BeanFactoryImpl;
import com.epam.university.java.project.core.cdi.io.Resource;

import java.util.Collection;

public class ApplicationContextImpl implements ApplicationContext {
    private BeanDefinitionRegistry beanDefinitionRegistry;
    private BeanDefinitionReader beanDefinitionReader;
    private BeanFactory beanFactory;

    /**
     * There are 3 dependencies for the constructor:
     * 1) BeanDefinitionRegistry - the place to load beans.
     * 2) BeanDefinitionReader - the tool to read beans from
     * XML and load into BeanDefinitionRegistry.
     * 3) BeanFactory - to create objects based on the definitions in the BeanDefinitionRegistry,
     * where BeanDefinitionReader has loaded beans
     */
    public ApplicationContextImpl() {
        beanDefinitionRegistry = new BeanDefinitionRegistryImpl();
        beanDefinitionReader = new BeanDefinitionReaderImpl(beanDefinitionRegistry);
        beanFactory = new BeanFactoryImpl(beanDefinitionRegistry);
    }

    @Override
    public int loadBeanDefinitions(Resource resource) {
        return beanDefinitionReader.loadBeanDefinitions(resource);
    }

    @Override
    public int loadBeanDefinitions(Collection<Resource> resources) {
        return beanDefinitionReader.loadBeanDefinitions(resources);
    }

    @Override
    public <T> T getBean(Class<T> beanClass) {
        return beanFactory.getBean(beanClass);
    }

    @Override
    public Object getBean(String beanName) {
        return beanFactory.getBean(beanName);
    }

    @Override
    public <T> T getBean(String beanName, Class<T> beanClass) {
        return beanFactory.getBean(beanName, beanClass);
    }
}
