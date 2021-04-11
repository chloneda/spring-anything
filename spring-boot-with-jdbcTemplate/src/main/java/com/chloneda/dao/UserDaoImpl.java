package com.chloneda.dao;

import com.chloneda.domain.User;
import com.chloneda.mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

/**
 * @author chloneda
 * @description:
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int create(User user) {
        String sql = "insert into user(id,name,sex,age,password,address,email,phone) values(:id,:name,:sex,:age,:password,:address,:email,:phone)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        return npjt.update(sql, new BeanPropertySqlParameterSource(user));
    }

    @Override
    public int update(User user) {
        String sql = "update user set name = ?,sex = ?,age = ?,password = ?,address = ?,email = ?,phone = ? where id = ?";
        Object[] args = {user.getName(), user.getSex(), user.getAge(), user.getPassword(), user.getAddress(), user.getEmail(), user.getPhone(), user.getId()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int delete(String userId) {
        String sql = "delete from user where id = ?";
        Object[] args = {userId};
        int[] argTypes = {Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String, Object>> getUsersList() {
        String sql = "select * from user";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public User getUserById(String userId) {
        String sql = "select * from user where id = ?";
        Object[] args = {userId};
        int[] argTypes = {Types.VARCHAR};
        List<User> userList = this.jdbcTemplate.query(sql, args, argTypes, new UserRowMapper());
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

}
