package com.magic.springboot.service;

import com.magic.springboot.model.Account;

import java.util.List;

/**
 * Created by chl
 * Description:
 */
public interface ITestService {

    public void test();

    public boolean transfer(float money, int from, int to) throws Exception;

    public int insertAccount(Account account) throws Exception;

    public Account findAccountById(int i);

    public List<Account> findAccountsById(int i);
}
