package com.chloneda.service;

import com.chloneda.domain.User;

import java.util.List;

public interface UserService {

    List<User> queryUsersList();

    User getUser(String id);

    void updateUser(User user);

    void deleteUserById(String userId);

    void create(User user);

}
