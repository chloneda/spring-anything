package com.chloneda.service;

import com.chloneda.domain.User;
import com.chloneda.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chloneda
 * @description: User 业务逻辑实现类
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(String userId) {
        return userMapper.selectById(userId);
    }

    @Override
    public void update(User user) {
        userMapper.updateById(user);
    }

    @Override
    public void create(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(String userId) {
        userMapper.deleteById(userId);
    }

}
