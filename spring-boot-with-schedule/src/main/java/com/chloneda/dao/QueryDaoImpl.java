package com.chloneda.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Created by chloneda
 * @Description:
 */
@Repository("queryDao")
public class QueryDaoImpl implements QueryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> query(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

}
