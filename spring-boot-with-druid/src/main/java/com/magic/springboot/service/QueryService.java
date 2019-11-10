package com.magic.springboot.service;

import java.util.List;
import java.util.Map;

/**
 * @Created by chloneda
 * @Description:
 */
public interface QueryService {

    List<Map<String,Object>> doQuery(String sql);

}
