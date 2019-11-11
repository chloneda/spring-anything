package com.chloneda.service;

import com.chloneda.mapper.AccountMapper;
import com.chloneda.model.Account;
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
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Resource
    private AccountMapper accountMapper;

    @Override
    public void test() {
    }

    @Transactional(propagation= Propagation.REQUIRED )
    @Override
    public boolean transfer(float money, int from, int to) throws Exception {
        this.accountMapper.minusMoney(from, money);
        int i = 1/0;
        this.accountMapper.addMoney(to, money);
        return true;
    }

    @Override
    public int insertAccount(Account account){
        return this.accountMapper.insertAccount(account);
    }

    @Override
    public Account findAccountById(int i) {
        return this.accountMapper.getAccountById(i);
    }

    @Override

    public List<Account> findAccountsById(int id) {
        List<Account> accounts = this.accountMapper.findAccountsById(id);
        return this.accountMapper.findAccountsById(id);
    }

}
