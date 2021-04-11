package com.chloneda.service;

import com.chloneda.domain.User;
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
    private UserService userService;

    @Test
    public void testFindAll() {
        List<User> userList = userService.findAll();

        /** forEach + Lambda表达式遍历List */
        userList.forEach(var -> System.out.println("用户名称{}: " + var.getName()));
    }

}
