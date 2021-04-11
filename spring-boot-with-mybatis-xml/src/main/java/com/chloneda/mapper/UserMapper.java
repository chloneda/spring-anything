package com.chloneda.mapper;

import com.chloneda.domain.User;

import java.util.List;

/**
 * @Created by chloneda
 * @Description: Spring Boot 集成 Mybatis
 */
public interface UserMapper {

    void delete(String userId);

    void update(User user);

    void create(User user);

    User getUserById(String userId);

    List<User> getUsersList();

}
