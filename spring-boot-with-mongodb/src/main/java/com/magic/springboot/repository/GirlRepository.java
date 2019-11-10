package com.magic.springboot.repository;

import com.magic.springboot.model.Girl;

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
