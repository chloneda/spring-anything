package com.chloneda.dao;

import com.chloneda.domain.User;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserDao extends DaoSupport<User>{

    /**
     *
     * @param userId
     * @return
     */
    List<User> getUserById(String userId);


    /**
     *
     * @param userId
     * @return
     */
    boolean hasUserById(String userId);

}
