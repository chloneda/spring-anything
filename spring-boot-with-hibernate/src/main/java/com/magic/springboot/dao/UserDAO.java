package com.magic.springboot.dao;

import com.magic.springboot.model.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserDAO {

    User getUserByName(String username);

    void save(Object o);

}
