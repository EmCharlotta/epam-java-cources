package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "list")
@XmlAccessorType(XmlAccessType.FIELD)
public class ListDefinitionImpl implements ListDefinition {
    @XmlElement(name = "value", type = ListItemDefinitionImpl.class)
    private Collection<ListItemDefinition> values;

    @Override
    public Collection<ListItemDefinition> getValues() {
        return values;
    }

    @Override
    public void setValues(Collection<ListItemDefinition> values) {
        this.values = values;
    }

}