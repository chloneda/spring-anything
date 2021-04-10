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
public class CacheServiceTest {

    @Autowired
    private CacheService cacheService;

    @Test
    public void testFindUserByName() {
        for (int i = 0; i < 10; i++) {
            User user = cacheService.findUserByName("lili");
            System.out.println("UserName: " + user.getName());
        }
    }

}
