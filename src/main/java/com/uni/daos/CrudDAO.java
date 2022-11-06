package com.uni.daos;

import java.util.List;

public interface CrudDAO<Entity> {

    Entity createInstance(Entity entity);
    List<Entity> getAll();

}
