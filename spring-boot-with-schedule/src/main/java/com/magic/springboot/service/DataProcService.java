package com.magic.springboot.service;

import java.util.List;
import java.util.Map;

/**
 * Created by chl on 2019/01/03
 * Description:
 */
public interface DataProcService {

    public List<Map<String,Object>> doQuery(String sql);


}
