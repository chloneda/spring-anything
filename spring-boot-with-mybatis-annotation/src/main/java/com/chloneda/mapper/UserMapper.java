package com.chloneda.mapper;

import com.chloneda.domain.User;
import org.apache.ibatis.annotations.*;

/**
 * @author chloneda
 * @description: UserMapper 接口类
 */
// 标志为 Mybatis 的 Mapper
@Mapper
public interface UserMapper {

    /**
     * 根据用户ID，查询User信息
     *
     * @param userId 用户ID
     */
    @Select("SELECT * FROM user WHERE id= #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "age", column = "age"),
            @Result(property = "password", column = "password"),
            @Result(property = "address", column = "address"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone")
    })
    User getUserById(@Param("id") String userId);

    @Delete("delete from user where id = #{id}")
    void delete(@Param(value = "id") String userId);

    @Update("update user set name = #{name} where id = #{id}")
    void update(User user);

    @Insert("insert into user (id,name,age,sex,password,address,email,phone) " +
            "values (#{id},#{name},#{age},#{sex},#{password},#{address},#{email},#{phone})")
        //@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
    void create(User user);

}