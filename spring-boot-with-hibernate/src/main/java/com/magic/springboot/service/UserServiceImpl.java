package com.magic.springboot.service;

import com.magic.springboot.dao.UserDAO;
import com.magic.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by chl
 * Description:
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public User getUser(String username) {
        return this.userDAO.getUserByName(username);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void transaction() throws Exception{
        User user = new User();
        user.setUsername("haili");
        this.userDAO.save(user);
    }
}
