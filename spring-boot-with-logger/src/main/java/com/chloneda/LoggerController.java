package com.chloneda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author chloneda
 * @description:
 */
@RestController(value = "logs")
public class LoggerController {

    private static final Logger logger = LoggerFactory.getLogger(LoggerController.class);

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String log() {
        logger.debug("LoggerController,time: {}", new Date());
        logger.info("LoggerController,time: {}", new Date());
        logger.warn("LoggerController,time: {}", new Date());
        logger.error("LoggerController,time: {}", new Date());
        return "spring-boot-with-logger!";
    }

}
