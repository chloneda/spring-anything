package com.chloneda.service;

import com.chloneda.model.Girl;

/**
 * @author chloneda
 * @description: Girl逻辑接口类
 */
public interface GirlService {

    /**
     * 根据美女名称，查询Girl信息
     *
     * @param girlId
     */
    Girl findGirlById(String girlId);

    /**
     * 根据美女ID删除
     *
     * @param girlId
     * @return
     */
    int delete(String girlId);

    int update(String girlId, String girlName);

    int create(Girl girl);

    Girl getGirlById(String girlId);

}
