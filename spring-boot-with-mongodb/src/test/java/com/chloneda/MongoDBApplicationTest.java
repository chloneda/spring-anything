package com.chloneda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoDBApplicationTest {

    @Test
    public void runApplication() {
        System.out.println("Hello MongoDB");
    }

}
