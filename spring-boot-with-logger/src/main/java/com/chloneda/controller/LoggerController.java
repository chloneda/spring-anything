package com.chloneda.controller;

import com.chloneda.exception.SpringException;
import com.chloneda.exception.SpringRuntimeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

/**
 * @author chloneda
 * @description:
 */
@RestController
@RequestMapping(value = "/logs")
public class LoggerController extends BaseController {

    /**
     * 使用父类的logger
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String createLog() {
        /** 打印日志使用占位符{}，减少字符串拼接时间，日志底层使用StringBuilder */
        logger.debug("LoggerController's debug log on time: {}", Instant.now());
        logger.info("LoggerController's info log on time: {}", Instant.now());
        logger.warn("LoggerController's warn log on time: {}", Instant.now());
        logger.error("LoggerController's error log on time: {}", Instant.now());
        return "spring-boot-with-logger!";
    }

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    public void createException() throws SpringException {
        throw new SpringException("抛出异常SpringException，全局异常类BaseController处理!");
    }

}
