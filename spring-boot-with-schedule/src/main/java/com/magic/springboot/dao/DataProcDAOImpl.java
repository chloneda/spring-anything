package com.magic.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by chl
 * Description:
 */
@Repository("dataProcDAO")
public class DataProcDAOImpl implements DataProcDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String,Object>> query(String sql) {
        return jdbcTemplate.queryForList(sql);
    }

}
