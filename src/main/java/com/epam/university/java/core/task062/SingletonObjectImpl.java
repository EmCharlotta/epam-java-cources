package com.epam.university.java.core.task062;

import java.io.Serializable;

public class SingletonObjectImpl implements SingletonObject, Serializable {
    static SingletonObjectImpl instance;

    static SingletonObjectImpl getInstance() {
        if (instance == null) {
            return new SingletonObjectImpl();
        }
        return instance;
    }
}
