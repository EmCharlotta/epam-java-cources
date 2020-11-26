package com.epam.university.java.project.core.cdi.structure;


import java.util.Collection;

/**
 * Definition of list.
 */
public interface ListDefinition extends StructureDefinition {
    /**
     * Get list items.
     * @return list items
     */
    Collection<ListItemDefinition> getValues();

    /**
     * Set list items.
     * @param values collection of list items
     */
    void setValues(Collection<ListItemDefinition> values);

    interface ListItemDefinition {
        /**
         * Get list item value.
         * @return item value
         */
        String getValue();

        /**
         * Set list item value.
         * @param value item value
         */
        void setValue(String value);
    }
}