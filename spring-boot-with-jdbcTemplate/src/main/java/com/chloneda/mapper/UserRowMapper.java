package com.chloneda.mapper;

import com.chloneda.domain.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author chloneda
 * @description:
 */
public class UserRowMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setSex(rs.getString("sex"));
        user.setAge(rs.getString("age"));
        user.setPassword(rs.getString("password"));
        user.setAddress(rs.getString("address"));
        user.setEmail(rs.getString("email"));
        user.setPhone(rs.getString("phone"));
        return user;
    }

}
