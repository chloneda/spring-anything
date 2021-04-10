package com.chloneda.dao.impl;

import com.chloneda.dao.UserDao;
import com.chloneda.domain.User;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@Repository
public class UserDaoImpl extends HibernateDaoSupport implements UserDao<User> {

    @Override
    public User getUserById(String userId) {
        return getHibernateTemplate().get(User.class,userId);
    }

    @Override
    public boolean hasUserById(String userId) {
        return false;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public User getById(String id) {
        return null;
    }

    @Override
    public List<User> getByIds(String[] ids) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User saveOrUpdate(User entity) {
        return null;
    }

    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Override
    public User getOneByName(String name) {
        return null;
    }

}
