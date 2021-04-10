package com.chloneda.service;

import com.chloneda.domain.User;
import com.chloneda.service.impl.UserServiceImpl;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class TestMybatis {
    private static UserService userService;

    @BeforeClass
    public static void setup() {
        userService = new UserServiceImpl();
    }

    @AfterClass
    public static void destroy() {
        userService = null;
    }

    @Test
    public void queryForList() {
        List<User> userList = userService.queryForList();
        Assert.assertNotNull(userList);
        System.out.println("======> userList: " + userList.toString());
    }

    @Test
    public void getUserAndOrders() {
        User user = userService.getUserAndOrders(1);
        Assert.assertNotNull(user);
        //user.getOrderList()为何为空
        System.out.println("======> user: " + user.toString() + " ======> " + user.getOrderList());
    }

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("Hello");
        user.setPassword("123456");
        user.setAddress("NEW-YORK");
        user.setBirthday(new Date());
        userService.create(user);
    }

    @Test
    public void deleteUserById() {
        boolean tmp = userService.deleteUserById(124);
        System.out.println(tmp);
    }
}