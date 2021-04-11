package com.chloneda.service;

import com.chloneda.domain.User;
import com.chloneda.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chloneda
 * @description: Girl业务逻辑实现类
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public void delete(String userId) {
        userMapper.delete(userId);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void create(User user) {
        userMapper.create(user);
    }

}
