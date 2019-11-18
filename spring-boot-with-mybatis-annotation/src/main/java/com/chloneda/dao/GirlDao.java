package com.chloneda.dao;

import com.chloneda.model.Girl;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author chloneda
 * @description: GirlDao 接口类
 */
// 标志为 Mybatis 的 Mapper
@Mapper
public interface GirlDao {

    /**
     * 根据美女ID，查询Girl信息
     *
     * @param girlId 美女ID
     */
    @Select("SELECT * FROM girl where id= #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "password", column = "password"),
            @Result(property = "address", column = "address"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone")
    })
    Girl findGirlById(@Param("id") String girlId);

    @Delete("delete from girl where id = #{id}")
    int delete(String girlId);

    @Update("update girl set name = #{girlName} where id = #{girlId}")
    int update(String girlId, String girlName);

    @Insert("insert into girl (id,name,age,address,email,phone) values (#{id},#{name},#{age},#{address},#{email},#{phone})")
        //@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
    int create(Girl girl);

    @Select("select * from girl where id = #{id}")
        //@Cacheable(value = "indexCache",key = "'getGirlById'+#id")
    Girl getGirlById(String girlId);

}