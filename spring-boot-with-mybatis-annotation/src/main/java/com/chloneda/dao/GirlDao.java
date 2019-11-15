package com.chloneda.dao;

import com.chloneda.model.Girl;
import org.apache.ibatis.annotations.*;

/**
 * @author chloneda
 * @description: GirlDao 接口类
 */
// 标志为 Mybatis 的 Mapper
@Mapper
public interface GirlDao {

    /**
     * 根据美女名称，查询Girl信息,返回 Map 结果集
     *
     * @param girlName 美女名称
     */
    @Select("SELECT * FROM girl where name= #{name}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age"),
            @Result(property = "sex", column = "sex"),
            @Result(property = "password", column = "password"),
            @Result(property = "address", column = "address"),
            @Result(property = "email", column = "email"),
            @Result(property = "phone", column = "phone")
    })
    Girl findGirlByName(@Param("name") String girlName);

}