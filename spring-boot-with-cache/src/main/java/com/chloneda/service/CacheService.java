package com.chloneda.service;

import com.chloneda.domain.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface CacheService {

    User findUserByName(String username);

    void remove(String userId);

    User findOne(User user);

}
