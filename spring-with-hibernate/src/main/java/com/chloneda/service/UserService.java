package com.chloneda.service;

import com.chloneda.domain.User;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserService {

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

    User save(User entity);

    void delete(String id);

    void update(User entity);

    User getById(String id);

    List<User> getByIds(String[] ids);

    List<User> findAll();

    User saveOrUpdate(User entity);

    List<User> getByName(String name);

    User getOneByName(String name);

}
