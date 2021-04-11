package com.chloneda.dao;

import com.chloneda.domain.User;
import org.junit.Assert;
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
public class UserDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void testGetUsersList() {
        System.out.println("查询用户列表: " + userDao.getUsersList());
    }

    @Test
    public void getUser() {
        User user = userDao.getUserById("1");
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
        userDao.create(user);
    }

    @Test
    public void deleteUserById() {
        int isDelete = userDao.delete("8");
        System.out.println("用户已删除：" + isDelete);
    }

}
