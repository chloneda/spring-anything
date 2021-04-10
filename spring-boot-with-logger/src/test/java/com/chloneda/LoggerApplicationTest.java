package com.chloneda;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author chloneda
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerApplicationTest {

    private static final Logger logger = LoggerFactory.getLogger(LoggerApplication.class);

    @Test
    public void runApplication() {
        logger.error("发生异常错误！");
    }

}
