package com.chloneda.service;

import com.chloneda.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    public void testFindAll() {
        List<User> userList = userService.findAll();
        /** forEach + Lambda表达式遍历List */
        userList.forEach(var -> System.out.println("用户名称{}: " + var.getName()));
    }

    @Test
    public void getUser() {
        User user = userService.getUserByName("hegel");
        Assert.assertNotNull(user);
        //user.getOrderList()为何为空
        System.out.println("User info: " + user.toString());
    }

    @Test
    public void insert() {
        User user = new User();
        user.setId("8");
        user.setName("Jingjing");
        user.setAge("18");
        user.setSex("woman");
        user.setPassword("123456");
        user.setEmail("Jingjing@163.com");
        user.setAddress("NEW YORK");
        user.setPhone("16616695036");
        userService.create(user);
    }

    @Test
    public void deleteUserById() {
        userService.delete("8");
        System.out.println("用户已删除");
    }

}
