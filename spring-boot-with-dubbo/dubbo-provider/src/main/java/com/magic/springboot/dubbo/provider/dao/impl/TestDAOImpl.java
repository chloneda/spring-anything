package com.magic.springboot.dubbo.provider.dao.impl;

import com.magic.springboot.dubbo.provider.dao.ITestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by chloneda
 */
@Repository(value = "testDAO")
public class TestDAOImpl implements ITestDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Object test() {
        return jdbcTemplate.queryForList("select * from test");
    }
}
