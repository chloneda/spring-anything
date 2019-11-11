package com.chloneda.service;

import com.chloneda.model.Account;

import java.util.List;

/**
 * @Created by chloneda
 * @Description:
 */
public interface AccountService {

    void test();

    boolean transfer(float money, int from, int to) throws Exception;

    int insertAccount(Account account) throws Exception;

    Account findAccountById(int i);

    List<Account> findAccountsById(int i);

}
