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
    public void testUsersList() {
        System.out.println("用户列表：" + userService.getUsersList().toString());
    }

    @Test
    public void testGetUserById() {
        System.out.println("用户地址信息："
                + userService.getUserById("1").getAddress());
    }

    @Test
    public void testCreate() {
        User user = new User();
        user.setId("9");
        user.setName("Liqizhao");
        user.setAge(18);
        user.setSex("woman");
        user.setPassword("admin");
        user.setAddress("GuangZhou");
        user.setEmail("Liqizhao@163.com");
        user.setPhone("132xxxx3156");
        userService.create(user);
        System.out.println("已新增用户！");
    }

    @Test
    public void testDelete() {
        userService.delete("9");
        System.out.println("已删除用户！");
    }

    @Test
    public void testUpdate() {
        User user = userService.getUserById("9");
        System.out.println("获取用户：" + user.toString());
        user.setName("Diaochan");
        userService.update(user);
        System.out.println("用户已更新");
    }

}
