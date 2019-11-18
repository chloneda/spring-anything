package com.chloneda.service;

import com.chloneda.mapper.GirlMapper;
import com.chloneda.model.Girl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Created by chloneda
 * @Description:
 */
@Service("girlService")
public class GirlServiceImpl implements GirlService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GirlServiceImpl.class);

    @Resource
    private GirlMapper girlMapper;

    @Override
    public int delete(String girlId) {
        return girlMapper.delete(girlId);
    }

    @Override
    public int update(String girlId, String girlName) {
        return girlMapper.update(girlId, girlName);
    }

    @Override
    public int create(Girl girl) {
        return girlMapper.create(girl);
    }

    @Override
    public Girl getGirlById(String girlId) {
        return girlMapper.getGirlById(girlId);
    }

}
