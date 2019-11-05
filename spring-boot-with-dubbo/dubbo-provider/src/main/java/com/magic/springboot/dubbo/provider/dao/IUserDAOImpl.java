package com.magic.springboot.dubbo.provider.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Created by chloneda
 */
@Repository(value = "testDAO")
public class IUserDAOImpl implements IUserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Object test() {
        return jdbcTemplate.queryForList("select * from mag_user");
    }
}
