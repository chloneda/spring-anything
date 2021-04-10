package com.chloneda.mapper;

import com.chloneda.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author chloneda
 * @description:
 */
public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getString("p_id"));
        user.setName(rs.getString("p_name"));
        user.setSex(rs.getString("p_sex"));
        user.setAge(rs.getString("p_age"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        return user;
    }

}
