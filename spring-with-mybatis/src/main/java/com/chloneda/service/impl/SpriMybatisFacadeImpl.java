package com.chloneda.service.impl;

import com.chloneda.dao.ItemsMapper;
import com.chloneda.dao.OrdersDetailMapper;
import com.chloneda.dao.OrdersMapper;
import com.chloneda.dao.UserMapper;
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

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private OrdersMapper ordersMapper;

    @Autowired
    private OrdersDetailMapper ordersDetailMapper;

}
