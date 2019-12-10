package com.chloneda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author chloneda
 * @description:
 */
@EnableScheduling
@SpringBootApplication
public class LoggerApplication {

    private static final Logger logger = LoggerFactory.getLogger(LoggerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
        logger.debug("LoggerApplication启动完成...");
        logger.info("LoggerApplication启动完成...");
        logger.warn("LoggerApplication启动完成...");
        logger.error("LoggerApplication启动完成...");
    }

}
