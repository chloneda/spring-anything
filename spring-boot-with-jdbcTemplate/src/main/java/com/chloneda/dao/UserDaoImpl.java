package com.chloneda.dao;

import com.chloneda.mapper.UserMapper;
import com.chloneda.model.User;
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
        String sql = "insert into mag_user(p_id,p_name,p_sex,p_age,address,email,phone) values(:p_id,:p_name,:p_sex,:p_age,:address,:email,:phone)";
        NamedParameterJdbcTemplate npjt = new NamedParameterJdbcTemplate(this.jdbcTemplate.getDataSource());
        return npjt.update(sql, new BeanPropertySqlParameterSource(user));
    }

    @Override
    public int update(User user) {
        String sql = "update mag_user set p_name = ?,p_sex = ? where p_id = ?";
        Object[] args = {user.getName(), user.getSex(), user.getId()};
        int[] argTypes = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public int delete(String userId) {
        String sql = "delete from mag_user where p_id = ?";
        Object[] args = {userId};
        int[] argTypes = {Types.VARCHAR};
        return this.jdbcTemplate.update(sql, args, argTypes);
    }

    @Override
    public List<Map<String, Object>> getUsersList() {
        String sql = "select * from mag_user";
        return this.jdbcTemplate.queryForList(sql);
    }

    @Override
    public User getUserById(String userId) {
        String sql = "select * from mag_user where p_id = ?";
        Object[] args = {userId};
        int[] argTypes = {Types.VARCHAR};
        List<User> userList = this.jdbcTemplate.query(sql, args, argTypes, new UserMapper());
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }

}
