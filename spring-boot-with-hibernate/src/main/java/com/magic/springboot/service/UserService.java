package com.magic.springboot.service;

import com.magic.springboot.model.User;

/**
 * Created by chl
 * Description:
 */
public interface UserService {

    User getUser(String username);

    public void transaction() throws Exception;

}
