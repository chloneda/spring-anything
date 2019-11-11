package com.chloneda.mapper;

import com.chloneda.model.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface AccountMapper {

    String ADD_MONEY = "update account set money = money+#{1} where id = #{0}";

    String MINUS_MONEY = "update account set money = money-#{1} where id = #{0}";

    String INSERT_ACCOUT = "insert into account (username,password,money) values (#{name},#{password},#{money})";

    String FIND_ACCOUNT_BY_ID = "select " +
            " id as id," +
            " username as username," +
            " password as password," +
            " money as money" +
            " from account " +
            " where " +
            " id = #{id}";

    String FIND_ACCOUNTS_BY_ID = "select " +
            " id as id," +
            " username as username," +
            " password as password," +
            " money as money" +
            " from account " +
            " where " +
            " id >= #{id}";

    @Update(ADD_MONEY)
    public int addMoney(int userId, float money);

    @Update(MINUS_MONEY)
    public int minusMoney(int userId, float money);

    @Insert(INSERT_ACCOUT)
    //@CacheEvict(value = {"indexCache"},allEntries = true,beforeInvocation = true)
    public int insertAccount(Account account);

    @Select(FIND_ACCOUNT_BY_ID)
    //@Cacheable(value = "indexCache",key = "'getAccountById'+#id")
    public Account getAccountById(int id);

    @Select(FIND_ACCOUNTS_BY_ID)
    //@Cacheable(value = "indexCache",key = "'findAccountsById'+#id")
    public List<Account> findAccountsById(int id);


}
