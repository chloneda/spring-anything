package com.chloneda.dubbo.provider.service;

import com.chloneda.dubbo.api.IUser;
import com.chloneda.dubbo.provider.dao.IUserDao;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Created by chloneda
 */
@Component
@Service(version = "1.0.0")
public class IUserServiceImpl implements IUser {

    @Autowired
    IUserDao iUserDao;

    @Override
    public String getFullName(String name) {
        return "getFullName:" + this.iUserDao.test().toString();
    }

    @Override
    public String getNickName(int id) {
        return "getNickName:" + this.iUserDao.test().toString();
    }

}
