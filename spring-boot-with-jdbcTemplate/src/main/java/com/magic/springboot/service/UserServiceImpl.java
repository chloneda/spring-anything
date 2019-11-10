package com.magic.springboot.service;

import com.magic.springboot.dao.UserDao;
import com.magic.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author chloneda
 * @description:
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int create(User user) {
        return this.userDao.create(user);
    }

    @Override
    public int update(User user) {
        return this.userDao.update(user);
    }

    @Override
    public int deleteUserById(String userId) {
        return this.userDao.deleteUserById(userId);
    }

    @Override
    public List<Map<String, Object>> queryUsersListMap() {
        return this.userDao.queryUsersListMap();
    }

    @Override
    public User queryUserById(String userId) {
        return this.userDao.queryUserById(userId);
    }
}
