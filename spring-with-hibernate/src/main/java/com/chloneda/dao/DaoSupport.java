package com.chloneda.dao;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface DaoSupport<T> {

    T save(T entity);

    void delete(String id);

    void update(T entity);

    T getById(String id);

    List<T> getByIds(String[] ids);

    List<T> findAll();

    T saveOrUpdate(T entity);

    List<T> getByName(String name);

    T getOneByName(String name);

}
