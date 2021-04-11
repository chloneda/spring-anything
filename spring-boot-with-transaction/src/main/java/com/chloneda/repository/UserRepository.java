package com.chloneda.repository;

import com.chloneda.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Created by chloneda
 * @Description:
 */
public interface UserRepository extends JpaRepository<User,String> {

    @Query("select u from User u where u.name=:name")
    User findUserByName(@Param("name") String name);

}
