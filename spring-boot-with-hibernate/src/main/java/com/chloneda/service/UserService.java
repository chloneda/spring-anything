package com.chloneda.service;

import com.chloneda.model.User;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserService {

    User getUser(String username);

    void transaction() throws Exception;

}
