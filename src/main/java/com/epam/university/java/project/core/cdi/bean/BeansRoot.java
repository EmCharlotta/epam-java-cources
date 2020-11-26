package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "beans")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeansRoot {
    @XmlElement(name = "bean", type = BeanDefinitionImpl.class)
    private Collection<BeanDefinition> collectionOfBeans;

    public Collection<BeanDefinition> getCollectionOfBeans() {
        return collectionOfBeans;
    }

    public void setCollectionOfBeans(Collection<BeanDefinition> collectionOfBeans) {
        this.collectionOfBeans = collectionOfBeans;
    }
}
