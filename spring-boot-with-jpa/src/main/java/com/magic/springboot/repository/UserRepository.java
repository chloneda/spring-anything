package com.magic.springboot.repository;

import com.magic.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by chl
 * Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("select u from User u where u.username=:username")
    User findByUsername(@Param("username")String username);

}
