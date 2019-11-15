package com.chloneda.service;

import com.chloneda.model.User;
import com.chloneda.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Created by chloneda
 * @Description:
 */
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public User getUserById(String userId) {
        return this.userDao.getUserById(userId);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transaction() throws Exception{
        User user = new User();
        user.setId("1502992309");
        user.setName("haili");
        user.setPassword("123456");
        user.setPhone("12382948123");
        user.setAge("19");
        user.setSex("man");
        user.setEmail("haili@163.com");
        user.setAddress("Guangzhou");
        this.userDao.save(user);
    }

}
