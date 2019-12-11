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

    /**
     * 阿里日志规约:
     * 【强制】应用中不可直接使用日志系统 (Log4j、Logback)中的API,而应依赖使用日志框架
     *  SLF4J中的API,使用门面模式的日志框架,有利于维护和各个类的日志处理方式统一。
     */
    private static final Logger logger = LoggerFactory.getLogger(LoggerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LoggerApplication.class, args);
        /** 打印日志使用占位符{}，减少字符串拼接时间，日志底层使用StringBuilder */
        logger.debug("{}启动完成...", "LoggerApplication");
        logger.info("{}启动完成...", "LoggerApplication");
        logger.warn("{}启动完成...", "LoggerApplication");
        logger.error("{}启动完成...", "LoggerApplication");
    }

}
