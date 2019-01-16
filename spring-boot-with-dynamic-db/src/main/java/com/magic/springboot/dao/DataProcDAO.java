package com.magic.springboot.dao;

import java.util.List;
import java.util.Map;

/**
 * Created by chl on 2019/01/07
 * Description:
 */
public interface DataProcDAO {

    /**
     * 执行SQL并返回查询结果
     * @param sql 执行SQL
     * @return
     */
    List<Map<String,Object>> query(String sql);
}
