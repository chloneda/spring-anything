package com.chloneda.repository;

import com.chloneda.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @Created by chloneda
 * @Description:
 */
@Repository
public interface CacheUserRepository extends JpaRepository<User,String> {

    @Query("select u from User u where u.name=:name")
    User findUserByName(@Param("name") String name);

}
