package com.chloneda.dao.impl;

import com.chloneda.dao.DaoSupport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.util.Collections;
import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@SuppressWarnings("unchecked")
public abstract class DaoSupportImpl<T> implements DaoSupport<T> {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private SessionFactory sessionFactory;

    private Class<T> clazz;

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    /**
     * 使用byName后就不需要手动写入了
     */
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public DaoSupportImpl() {
        /**
         * 获取当前new的对象的泛型的父类类型
         */
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();

        /**
         * 获取第一个类型参数的真实类型,就是T
         */
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0];
    }

    public DaoSupportImpl(Class<T> clazz) {
        this.clazz = clazz;
    }


    @Override
    public T save(T entity) {
        getSession().save(entity);
        return entity;
    }

    @Override
    public void update(T entity) {
        getSession().saveOrUpdate(entity);
    }

    @Override
    public void delete(String id) {
        T obj = getById(id);
        getSession().delete(obj);
    }

    @Override
    public T saveOrUpdate(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public T getById(String id) {
        if (id == null || id.length() == 0) {
            return null;
        } else {
            return (T) getSession().get(clazz, id);
        }
    }

    @Override
    public List<T> getByIds(String[] ids) {
        /**
         * 对于返回值是空的情况,不要返回null,应该返回空集合
         */
        if (ids == null || ids.length == 0) {
            return Collections.emptyList();
        } else {
            return (List<T>) getSession().createQuery(
                    "FROM " + clazz.getSimpleName() + " WHERE id  IN (:ids)")
                    .setCacheable(true)
                    .setParameterList("ids", ids).list();
        }
    }

    @Override
    public List<T> findAll() {
        return (List<T>) getSession()
                .createQuery("FROM " + clazz.getSimpleName())
                .setCacheable(true)
                .list();
    }

    @Override
    public List<T> getByName(String name) {
        if (null != name){
            return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE name=?")
                    .setParameter(0, name)
                    .setCacheable(true)
                    .list();
        }
        return getSession().createQuery("FROM " + clazz.getSimpleName() + " WHERE name is null")
                .setCacheable(true)
                .list();
    }

    @Override
    public T getOneByName(String name) {
        logger.info(name);
        List<T> list = getByName(name);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

}
