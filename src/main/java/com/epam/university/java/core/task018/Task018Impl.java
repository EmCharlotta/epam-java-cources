package com.epam.university.java.core.task018;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Task018Impl implements Task018 {
    @Override
    public boolean isAnnotationPresent(Object toCheck, Class<?> annotationToFind) {
        try {
            @SuppressWarnings("unchecked")
            Class<? extends Annotation> annotation = (Class<? extends Annotation>) annotationToFind;
            Field[] fields = toCheck.getClass().getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(annotation)) {
                    return true;
                }
            }
            Constructor[] constructors = toCheck.getClass().getConstructors();
            for (Constructor constructor : constructors) {
                if (constructor.isAnnotationPresent(annotation)) {
                    return true;
                }
            }

            Method[] methods = toCheck.getClass().getMethods();
            for (Method method : methods) {
                if (method.isAnnotationPresent(annotation)) {
                    return true;
                }
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    if (parameter.isAnnotationPresent(annotation)) {
                        return true;
                    }
                }
            }
            Package pack = toCheck.getClass().getPackage();
            if (pack.isAnnotationPresent(annotation)) {
                return true;
            }
            if (toCheck.getClass().isAnnotationPresent(annotation)) {
                return true;
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return false;
    }
}
