package com.magic.springboot.dubbo.provider.service;

import com.magic.springboot.dubbo.api.IPerson;
import com.magic.springboot.dubbo.provider.dao.ITestDAO;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chloneda
 */
@Component
@Service(version = "1.0.0")
public class PersonServiceImpl implements IPerson {

    @Autowired
    ITestDAO testDAO;

    @Override
    public String getFullName(String name) {

        return "getFullName:" + this.testDAO.test().toString();
    }

    @Override
    public String getNickName(int id) {
        return "getNickName:" + this.testDAO.test().toString();
    }
}
