package com.chloneda.service;

import com.chloneda.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserService {

    User getUserByName(String username);

    User create(User user);

    void delete(String userId);

    User update(User user);

    List<User> findAll();

    List<User> findUsersByGender(String gender, Sort sort);

    Page<User> findUsersByGender(String gender, Pageable pageable);

}
