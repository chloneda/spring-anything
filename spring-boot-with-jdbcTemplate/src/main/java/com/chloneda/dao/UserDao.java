package com.chloneda.dao;

import com.chloneda.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author chloneda
 * @description:
 */
public interface UserDao {

    int create(User user);

    int update(User user);

    int delete(String userId);

    List<Map<String, Object>> getUsersList();

    User getUserById(String userId);

}
