package com.chloneda.service;

import com.chloneda.dao.GirlDao;
import com.chloneda.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chloneda
 * @description: Girl业务逻辑实现类
 */
@Service
public class GirlServiceImpl implements GirlService{

    @Autowired
    private GirlDao girlDao;

    @Override
    public Girl findGirlByName(String cityName) {
        return girlDao.findByName(cityName);
    }
}
