package com.chloneda.service.impl;

import com.chloneda.dao.UserDao;
import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Created by chloneda
 * @Description: 用户业务处理类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> getUserById(String userId) {
        return userDao.getUserById(userId);
    }

    @Override
    public boolean hasUserById(String userId) {
        return userDao.hasUserById(userId);
    }

    @Override
    public User save(User entity) {
        return userDao.save(entity);
    }

    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void update(User entity) {
        userDao.update(entity);
    }

    @Override
    public User getById(String id) {
        return userDao.getById(id);
    }

    @Override
    public List<User> getByIds(String[] ids) {
        return userDao.getByIds(ids);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User saveOrUpdate(User entity) {
        return userDao.saveOrUpdate(entity);
    }

    @Override
    public List<User> getByName(String name) {
        return userDao.getByName(name);
    }

    @Override
    public User getOneByName(String name) {
        return userDao.getOneByName(name);
    }

}
