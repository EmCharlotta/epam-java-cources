package com.epam.university.java.project.core.cdi.structure;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@XmlRootElement(name = "map")
@XmlAccessorType(XmlAccessType.FIELD)
public class MapDefinitionImpl implements MapDefinition {
    @XmlElement(name = "entry", type = MapEntryDefinitionImpl.class)
    private Collection<MapEntryDefinition> entries;

    @Override
    public Collection<MapEntryDefinition> getEntries() {
        return entries;
    }

    @Override
    public void setEntries(Collection<MapEntryDefinition> entries) {
        this.entries = entries;
    }
}
