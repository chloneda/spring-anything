package com.magic.springboot.service;

import com.magic.springboot.model.User;

/**
 * Created by chl
 * Description:
 */
public interface UserService {

    User findUser(String username);

}
