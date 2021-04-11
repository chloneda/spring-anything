package com.chloneda.service.impl;

import com.chloneda.dao.UserMapper;
import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import com.chloneda.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public List<User> queryUsersList() {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUsersList();
        sqlSession.close();
        return userList;
    }

    @Override
    public User getUser(String id) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUser(id);
        sqlSession.close();
        return user;
    }

    @Override
    public void updateUser(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper =sqlSession.getMapper(UserMapper.class);
        userMapper.updateUser(user);
        sqlSession.close();
    }

    @Override
    public void deleteUserById(String userId) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.deleteUser(userId);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void create(User user) {
        SqlSession sqlSession = SqlSessionFactoryUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        userMapper.create(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
