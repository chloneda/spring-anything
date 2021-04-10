package com.chloneda.service;

import com.chloneda.domain.User;

import java.util.List;

public interface UserService {

    public List<User> queryForList();

    public User getUserAndOrders(int userId);

    public boolean updateUserAndOrders();

    public boolean deleteUserById(int userId);

    public void create(User user);

}
