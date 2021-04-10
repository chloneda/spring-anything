package com.chloneda.service.impl;

import com.chloneda.dao.UserDao;
import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import com.chloneda.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserServiceImpl implements UserService {

    private SqlSessionFactoryUtils sqlSessionFactoryUtils;

    public List<User> queryForList() {
        SqlSession sqlSession = sqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getResultMap();
        sqlSession.close();
        return userList;
    }

    public User getUserAndOrders(int id) {
        SqlSession sqlSession = sqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.getUserAndOrders(id);
        sqlSession.close();
        return user;
    }

    public boolean updateUserAndOrders() {
        return false;
    }

    public boolean deleteUserById(int userId) {
        SqlSession sqlSession = sqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        boolean result = userDao.deleteUserById(userId);
        sqlSession.commit();
        sqlSession.close();
        return result;
    }

    public void create(User user) {
        SqlSession sqlSession = sqlSessionFactoryUtils.getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.create(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
