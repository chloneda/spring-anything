package com.chloneda.dao;

import com.chloneda.domain.User;

import java.util.List;

/**
 * Created by chloneda
 * Description:
 */
public interface UserMapper {

    public List<User> getUserById(String userId);


    public boolean hasUserById(String userId);

}
