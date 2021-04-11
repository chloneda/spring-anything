package com.chloneda.repository;

import com.chloneda.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("select u from User u where u.name=:name")
    User findUserByName(@Param("name") String name);

    /**
     * @param userSex
     * @param sort    指定排序的参数
     * @return List
     * Param的值和=:后面的参数匹配
     */
    @Query("select u from User u where u.sex=:sex")
    List<User> findUsersBySex(@Param("sex") String userSex, Sort sort);

    @Query("select u from User u where u.sex=:sex")
    Page<User> findUsersBySex(@Param("sex") String gender, Pageable pageable);

}
