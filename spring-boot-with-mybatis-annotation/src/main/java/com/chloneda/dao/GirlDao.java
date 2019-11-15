package com.chloneda.dao;

import com.chloneda.model.Girl;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author chloneda
 * @description: GirlDao 接口类
 */
// 标志为 Mybatis 的 Mapper
@Mapper
public interface GirlDao {

    /**
     * 根据美女ID，查询Girl信息,返回 Map 结果集
     *
     * @param girlId 美女ID
     */
    @Select("SELECT * FROM girl where id= #{id}")
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
    Girl findGirlById(@Param("id") String girlId);




    String ADD_MONEY = "update account set money = money+#{1} where id = #{0}";

    String MINUS_MONEY = "update account set money = money-#{1} where id = #{0}";

    String INSERT_ACCOUT = "insert into account (username,password,money) values (#{name},#{password},#{money})";

    String GET_GIRL_BY_ID = "select " +
            " id as id," +
            " username as username," +
            " password as password," +
            " money as money" +
            " from account " +
            " where " +
            " id = #{id}";

    @Update(ADD_MONEY)
    public int addMoney(int userId, float money);

    @Update(MINUS_MONEY)
    public int minusMoney(int userId, float money);

    @Insert(INSERT_ACCOUT)
    //@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
    int insert(Girl girl);

    @Select(GET_GIRL_BY_ID)
    //@Cacheable(value = "indexCache",key = "'getGirlById'+#id")
    Girl getGirlById(String girlId);


}