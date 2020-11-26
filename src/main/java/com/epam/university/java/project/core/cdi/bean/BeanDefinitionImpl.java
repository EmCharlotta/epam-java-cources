package com.epam.university.java.project.core.cdi.bean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "bean")
@XmlAccessorType(XmlAccessType.FIELD)
public class BeanDefinitionImpl implements BeanDefinition {
    @XmlAttribute(name = "id")
    private String id;
    @XmlAttribute(name = "class")
    private String className;
    @XmlAttribute(name = "init")
    private String methodName;
    @XmlAttribute(name = "scope")
    private String scope;

    @XmlElement(name = "property", type = BeanPropertyDefinitionImpl.class)
    private Collection<BeanPropertyDefinition> beanPropertyDefinitionList;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getClassName() {
        return className;
    }

    @Override
    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public Collection<BeanPropertyDefinition> getProperties() {
        return beanPropertyDefinitionList;
    }

    @Override
    public void setProperties(Collection<BeanPropertyDefinition> properties) {
        beanPropertyDefinitionList = properties;
    }

    @Override
    public String getPostConstruct() {
        return methodName;
    }

    @Override
    public void setPostConstruct(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String getScope() {
        return scope;
    }

    @Override
    public void setScope(String scope) {
        this.scope = scope;
    }
}