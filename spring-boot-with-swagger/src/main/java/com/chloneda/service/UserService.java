package com.chloneda.service;

import com.chloneda.dto.DtoUser;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserService {

    DtoUser findUser(String username);

    DtoUser createUser(DtoUser user);

    void deleteUser(String userId);

    DtoUser updateUser(DtoUser user);

    List<DtoUser> findAll();

}
