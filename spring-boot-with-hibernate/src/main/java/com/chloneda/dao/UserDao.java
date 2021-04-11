package com.chloneda.dao;

import com.chloneda.domain.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserDao {

    User getUserById(String userId);

    void save(Object o);

}
