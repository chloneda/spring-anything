package com.magic.springboot.service;

import com.magic.springboot.model.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserService {

    User getUser(String username);

    void transaction() throws Exception;

}
