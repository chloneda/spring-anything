package com.chloneda.service;

import com.chloneda.domain.User;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserService {

    void delete(String userId);

    void update(User user);

    void create(User user);

    User getUserById(String userId);

    List<User> getUsersList();

}
