package com.chloneda.dao;

import com.chloneda.model.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserDao {

    User getUserById(String username);

    void save(Object o);

}
