package com.chloneda.dao;

import com.chloneda.model.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserDao {

    User getUserByName(String username);

    void save(Object o);

}
