package com.chloneda.service;

import com.chloneda.domain.User;

import java.util.List;
import java.util.Map;

/**
 * @author chloneda
 * @description:
 */
public interface UserService {

    int create(User user);

    int update(User user);

    int delete(String userId);

    List<Map<String, Object>> getUsersList();

    User getUserById(String userId);
}
