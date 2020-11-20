package com.epam.university.java.core.task041;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Task041Impl implements Task041 {
    int id = 0;

    @Override
    public Entity create(Collection<Entity> collection, String value) {
        try {
            EntityImpl entity = new EntityImpl();
            entity.setValue(value);
            entity.setId(id);
            id++;
            collection.add(entity);
            return entity;
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public Entity read(Collection<Entity> collection, Entity entity) {
        try {
            Iterator<Entity> iterator = collection.iterator();
            while (iterator.hasNext()) {
                Entity res = iterator.next();
                if (entity.equals(res)) {
                    return res;
                }
            }
        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
        return null;
    }

    @Override
    public void update(Collection<Entity> collection, Entity entity, String value) {
        try {
            if (!collection.contains(entity)) {
                throw new IllegalArgumentException();
            }
            Iterator<Entity> iterator = collection.iterator();
            while (iterator.hasNext()) {
                EntityImpl res = (EntityImpl) iterator.next();
                if (entity.equals(res)) {
                    res.setValue(value);
                }
            }
        } catch (NullPointerException | NoSuchElementException e) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public void delete(Collection<Entity> collection, Entity entity) {
        try {
            collection.remove(entity);

        } catch (NullPointerException e) {
            throw new IllegalArgumentException();
        }
    }
}
