package com.chloneda.service;

import com.chloneda.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void testGetUserById() {
        System.out.println("======> " + userService.getUserById("001").getAddress());
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setId("8");
        user.setName("Jingjing");
        user.setAge(18);
        user.setSex("womam");
        user.setAddress("GuangZhou");
        user.setEmail("Jingjing@163.com");
        user.setPhone("132-xxxx-3156");
        userService.create(user);
        System.out.println("用户已新增：" + user.toString());
    }

    @Test
    public void testDelete() {
        userService.delete("8");
        System.out.println("用户已删除");
    }

    @Test
    public void testUpdate() {
        String userId = "8";
        User user = userService.getUserById(userId);
        user.setName("爱丽斯");
        userService.update(user);
        System.out.println("用户已更新：" + user.toString());
    }

}
