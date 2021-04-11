package com.chloneda.service;

import com.chloneda.dao.UserDao;
import com.chloneda.domain.User;
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
    public int delete(String userId) {
        return this.userDao.delete(userId);
    }

    @Override
    public List<Map<String, Object>> getUsersList() {
        return this.userDao.getUsersList();
    }

    @Override
    public User getUserById(String userId) {
        return this.userDao.getUserById(userId);
    }

}
