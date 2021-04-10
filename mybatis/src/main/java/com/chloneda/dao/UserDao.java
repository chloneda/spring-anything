package com.chloneda.dao;

import com.chloneda.domain.User;

import java.util.List;

public interface UserDao {

    public List<User> getResultMap();

    public User getUserAndOrders(int id);

    public boolean updateUserAndOrders();

    public boolean deleteUserById(int userId);

    public void create(User user);

}
