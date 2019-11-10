package com.magic.springboot.service;

import com.magic.springboot.dao.UserDao;
import com.magic.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by chloneda
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUser(String username) {
        return this.userDao.getUserByName(username);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transaction() throws Exception{
        User user = new User();
        user.setId("1502992309");
        user.setName("haili");
        user.setPhone("12382948123");
        user.setAge("19");
        user.setEmail("haili@163.com");
        user.setAddress("Guangzhou");
        this.userDao.save(user);
    }
}
