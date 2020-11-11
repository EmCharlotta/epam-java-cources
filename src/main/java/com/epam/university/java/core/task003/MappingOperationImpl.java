package com.epam.university.java.core.task003;

public class MappingOperationImpl implements MappingOperation {
    @Override
    public String map(String source) {
        StringBuilder builder = new StringBuilder(source);
        String mapped = builder.reverse().toString();
        return mapped;
    }
}
