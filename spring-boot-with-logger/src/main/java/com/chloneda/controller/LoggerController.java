package com.chloneda.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * @author chloneda
 * @description:
 */
@RestController(value = "/logs")
public class LoggerController {

    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String log() {
        /** 打印日志使用占位符{}，减少字符串拼接时间，日志底层使用StringBuilder */
        logger.debug("LoggerController's debug log on time: {}", Instant.now());
        logger.info("LoggerController's info log on time: {}", Instant.now());
        logger.warn("LoggerController's warn log on time: {}", Instant.now());
        logger.error("LoggerController's error log on time: {}", Instant.now());
        return "spring-boot-with-logger!";
    }

}
