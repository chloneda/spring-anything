package com.chloneda.service;

import com.chloneda.model.User;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface CacheService {

    User findUserByName(String username);

    void remove(String userId);

    User findOne(User user);

}
