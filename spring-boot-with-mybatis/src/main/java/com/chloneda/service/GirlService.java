package com.chloneda.service;

import com.chloneda.model.Girl;

/**
 * @Created by chloneda
 * @Description:
 */
public interface GirlService {

    int delete(String girlId);

    int update(String girlId, String girlName);

    int create(Girl girl);

    Girl getGirlById(String girlId);

}
