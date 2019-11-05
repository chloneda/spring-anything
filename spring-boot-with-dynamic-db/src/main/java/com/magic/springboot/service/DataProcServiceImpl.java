package com.magic.springboot.service;

import com.magic.springboot.dao.DataProcDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @Created by chloneda
 * @Description:
 */
@Service("dataProcService")
public class DataProcServiceImpl implements DataProcService {
    
    @Autowired
    private DataProcDAO dataProcDAO;

    @Override
    public List<Map<String, Object>> doQuery(String sql) {
        validateQuerySql(sql);
        return dataProcDAO.query(sql);
    }

    private void validateQuerySql(String sql){
        Assert.notNull(sql, "SQL must not be null!");
        String targetSql=sql.toLowerCase();
        if (targetSql.startsWith("update")
                || targetSql.startsWith("delete")
                || targetSql.startsWith("alert")
                || targetSql.startsWith("drop")
                || targetSql.startsWith("insert")) {
            throw new RuntimeException("SQL合规校验失败，不能是alert|update|drop|delete|insert操作");
        }
    }
    
    
    
    
    
    
}
