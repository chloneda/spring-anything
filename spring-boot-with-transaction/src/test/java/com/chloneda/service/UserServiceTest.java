package com.chloneda.service;

import com.chloneda.model.User;
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
    public void testCreate(){
        User user=new User();
        user.setId("001");
        user.setName("lili");
        user.setAge("18");
        user.setSex("woamn");
        user.setAddress("BeiJing");
        user.setEmail("lili@163.com");
        user.setPhone("131-xxxx-8139");
        userService.create(user);
    }

}
