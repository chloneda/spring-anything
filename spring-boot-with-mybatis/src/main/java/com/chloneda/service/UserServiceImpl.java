package com.chloneda.service;

import com.chloneda.mapper.UserMapper;
import com.chloneda.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
@Service("testService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    private UserMapper userMapper;

    public void test() {
    }

    @Transactional(propagation= Propagation.REQUIRED )
    @Override
    public boolean transfer(float money, int from, int to) throws Exception {

        this.userMapper.minusMoney(from, money);
        int i = 1/0;
        this.userMapper.addMoney(to, money);
        return true;
    }

    @Override
    public int insertAccount(User account){
        return this.userMapper.insertAccount(account);
    }

    @Override
    public User findAccountById(int i) {
        return this.userMapper.getAccountById(i);
    }

    @Override

    public List<User> findAccountsById(int i) {
        List<User> accounts = this.userMapper.findAccountsById(i);
        return this.userMapper.findAccountsById(i);
    }

}
