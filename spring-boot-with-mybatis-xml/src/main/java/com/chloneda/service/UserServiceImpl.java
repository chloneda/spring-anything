package com.chloneda.service;

import com.chloneda.domain.User;
import com.chloneda.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@Service("girlService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

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

    @Override
    public User getUserById(String userId) {
        return userMapper.getUserById(userId);
    }

    @Override
    public List<User> getUsersList(){
        return userMapper.getUsersList();
    }
}
