package com.chloneda.dao;

import com.chloneda.domain.User;

import java.util.List;

public interface UserMapper {

    List<User> getUsersList();

    User getUser(String id);

    void updateUser(User user);

    void deleteUser(String id);

    void create(User user);

}
