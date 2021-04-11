package com.chloneda.service;

import com.chloneda.domain.User;
import com.chloneda.service.impl.UserServiceImpl;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

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
        List<User> userList = userService.queryUsersList();
        Assert.assertNotNull(userList);
        System.out.println("======> userList: " + userList.toString());
    }

    @Test
    public void getUser() {
        User user = userService.getUser("1");
        Assert.assertNotNull(user);
        //user.getOrderList()为何为空
        System.out.println("User info: " + user.toString());
    }

    @Test
    public void insert() {
        User user = new User();
        user.setId("8");
        user.setName("Jingjing");
        user.setAge(18);
        user.setSex("woman");
        user.setPassword("123456");
        user.setEmail("Jingjing@163.com");
        user.setAddress("NEW YORK");
        user.setPhone("16616695036");
        userService.create(user);
    }

    @Test
    public void deleteUserById() {
        String userId = "8";
        User user = userService.getUser(userId);
        userService.deleteUserById(userId);
        System.out.println(user.getName()+ " 用户已删除");
    }
}