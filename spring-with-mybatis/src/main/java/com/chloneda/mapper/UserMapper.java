package com.chloneda.mapper;

import com.chloneda.domain.User;

import java.util.List;

/**
 * Created by chloneda
 * Description:
 */
public interface UserMapper {

    List<User> getUsersList();

    User getUserById(String userId);

}
