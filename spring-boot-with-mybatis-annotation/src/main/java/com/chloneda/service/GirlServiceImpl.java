package com.chloneda.service;

import com.chloneda.dao.GirlDao;
import com.chloneda.model.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chloneda
 * @description: Girl业务逻辑实现类
 */
@Service("girlService")
public class GirlServiceImpl implements GirlService {

    @Autowired
    private GirlDao girlDao;

    @Override
    public Girl findGirlById(String girlId) {
        return girlDao.findGirlById(girlId);
    }

    @Override
    public int delete(String girlId) {
        return girlDao.delete(girlId);
    }

    @Override
    public int update(String girlId, String girlName) {
        return girlDao.update(girlId,girlName);
    }

    @Override
    public int create(Girl girl) {
        return girlDao.create(girl);
    }

    @Override
    public Girl getGirlById(String girlId) {
        return girlDao.getGirlById(girlId);
    }

}
