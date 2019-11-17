package com.chloneda.mapper;

import com.chloneda.model.Girl;

/**
 * @Created by chloneda
 * @Description:
 */
public interface GirlMapper {

    int delete(String girlId);

    int update(String girlId, String girlName);

    int create(Girl girl);

    Girl getGirlById(String girlId);

}
