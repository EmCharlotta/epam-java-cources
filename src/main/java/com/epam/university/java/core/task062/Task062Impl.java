package com.epam.university.java.core.task062;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Task062Impl implements Task062 {
    @Override
    public OutputStream objectSerialization(Object obj) {
        ByteArrayOutputStream temp = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(temp)) {
            out.writeObject(obj);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return temp;
    }

    @Override
    public Object objectDeserialization(OutputStream outStream) {
        ByteArrayOutputStream temp = (ByteArrayOutputStream) outStream;
        ByteArrayInputStream in = new ByteArrayInputStream(temp.toByteArray());
        Object res = null;
        try (ObjectInputStream input = new ObjectInputStream(in)) {
            res = input.readObject();
            if (res instanceof SingletonObject) {
                return SingletonObjectImpl.getInstance();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }
}
