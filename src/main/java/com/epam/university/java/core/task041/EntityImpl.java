package com.epam.university.java.core.task041;

public class EntityImpl implements Entity {
    int id;
    String value;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setId(int id) {
        this.id = id;
    }
}
