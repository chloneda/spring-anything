package com.chloneda.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @author chloneda
 * @description:
 */
@Component
public class LogTask {

    private static final Logger logger = LoggerFactory.getLogger(LogTask.class);

    /**
     * 定时任务，cron表达式参考：spring-boot-with-schedule
     */
    @Scheduled(cron = "0/10 * * * * ?")
    public void produceLogs() {
        /** 字符串拼接效率低 */
        logger.info("定时任务启动时间(字符串拼接效率低): " + Instant.now());
        /** 打印日志使用占位符{}，减少字符串拼接时间，日志底层使用StringBuilder */
        logger.info("定时任务启动时间: {}", Instant.now());
        logger.warn("定时任务在运行: {}", Instant.now());
        logger.debug("Debug定时任务: {}", Instant.now());
        logger.error("定时任务严重错误: {}", Instant.now());
    }

    /**
     * if (logger.isDebugEnabled()) {
     *      logger.debug("xxx");
     * }
     */

}
