package com.chloneda.service;

import com.chloneda.domain.User;

/**
 * @author chloneda
 * @description:
 */
public interface UserService {

    /**
     * 创建用户
     * @param user
     * @return
     */
    boolean add(User user);

    /**
     * 创建用户
     * @param user
     * @return
     */
    boolean create(User user);

    /**
     * 创建用户
     * @param user
     * @return
     */
    boolean createUser(User user);

}
