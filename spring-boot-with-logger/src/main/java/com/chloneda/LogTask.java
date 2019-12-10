package com.chloneda;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Date;

/**
 * @author chloneda
 * @description:
 */
public class LogTask {

    private static final Logger logger = LoggerFactory.getLogger(LogTask.class);

    /**
     * 定时任务，cron表达式参考：spring-boot-with-schedule
     */
    @Scheduled(cron = "0/3 * * * * ?")
    public void produceLogs() {
        logger.info("定时任务启动时间：{}", new Date());
        logger.warn("定时任务在运行！");
        logger.debug("我是debug定时任务");
        logger.error("定时任务严重错误！！！");
    }

}
