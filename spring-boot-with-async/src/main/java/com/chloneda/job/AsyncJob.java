package com.chloneda.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
 * @author chloneda
 * @description: 任务类，用于测试异步执行
 */
@Component
public class AsyncJob {

    @Async
    public Future<String> runJob1() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(1000);
        long endTime = System.currentTimeMillis();
        System.out.println("RunJob1任务耗时: " + (endTime - startTime) + "ms");
        return new AsyncResult<String>("RunJob1任务完成");
    }

    @Async
    public Future<String> runJob2() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(2000);
        long endTime = System.currentTimeMillis();
        System.out.println("RunJob2任务耗时: " + (endTime - startTime) + "ms");
        return new AsyncResult<String>("RunJob1任务完成");
    }

    @Async
    public Future<String> runJob3() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Thread.sleep(3000);
        long endTime = System.currentTimeMillis();
        System.out.println("RunJob3任务耗时: " + (endTime - startTime) + "ms");
        return new AsyncResult<String>("RunJob1任务完成");
    }

}
