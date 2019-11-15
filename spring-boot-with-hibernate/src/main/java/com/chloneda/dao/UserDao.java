package com.chloneda.dao;

import com.chloneda.model.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserDao {

    User getUserById(String userId);

    void save(Object o);

}
