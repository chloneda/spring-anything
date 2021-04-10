package com.chloneda.service;

import com.chloneda.model.User;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserService {

    User getUserByName(String username);

    User create(User user);

    void delete(String userId);

    User update(User user);

    List<User> findAll();

}
