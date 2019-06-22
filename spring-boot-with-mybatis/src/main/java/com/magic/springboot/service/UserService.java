package com.magic.springboot.service;

import com.magic.springboot.model.User;

import java.util.List;

/**
 * Created by chl
 * Description:
 */
public interface UserService {

    public void test();

    public boolean transfer(float money, int from, int to) throws Exception;

    public int insertAccount(User account) throws Exception;

    public User findAccountById(int i);

    public List<User> findAccountsById(int i);

}
