package com.chloneda.repository;

import com.chloneda.model.Girl;

/**
 * @author chloneda
 * @description:
 */
public interface GirlRepository {

    void create(Girl girl);

    Girl findGirlByName(String girlName);

    long update(Girl girl);

    void deleteGirlById(String id);

}
