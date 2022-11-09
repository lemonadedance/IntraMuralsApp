package com.uni.daos;

import java.util.List;

public interface CrudDAO<Entity> {

    Entity save(Entity entity);
    List<Entity> findAll();

}
