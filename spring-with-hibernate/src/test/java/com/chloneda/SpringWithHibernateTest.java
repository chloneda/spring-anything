package com.chloneda;

import com.chloneda.domain.User;
import com.chloneda.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-hibernate.xml")
public class SpringWithHibernateTest {

    @Resource
    private UserService userService;

    @Test
    public void testSave() {
        User user = new User();
        user.setId("005");
        user.setName("lili");
        user.setAge("18");
        user.setSex("woman");
        user.setPassword("123456");
        user.setAddress("BeiJing");
        user.setEmail("lili@163.com");
        user.setPhone("131-xxxx-8139");
        userService.save(user);
    }

    @Test
    public void testGet() {
        User user = userService.getById("001");
        System.out.println(user.getName());
    }

}
