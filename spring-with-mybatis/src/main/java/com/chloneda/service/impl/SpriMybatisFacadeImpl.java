package com.chloneda.service.impl;

import com.chloneda.mapper.UserMapper;
import com.chloneda.service.SpriMybatisFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by chloneda
 * Description:
 */
@Service
public class SpriMybatisFacadeImpl implements SpriMybatisFacade {

    @Autowired
    private UserMapper userMapper;

}
