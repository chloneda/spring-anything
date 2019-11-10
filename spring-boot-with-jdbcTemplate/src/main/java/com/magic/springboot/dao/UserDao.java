package com.magic.springboot.dao;

import com.magic.springboot.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author chloneda
 * @description:
 */
public interface UserDao {

    int create(User user);

    int update(User user);

    int deleteUserById(String userId);

    List<Map<String, Object>> queryUsersListMap();

    User queryUserById(String userId);

}
