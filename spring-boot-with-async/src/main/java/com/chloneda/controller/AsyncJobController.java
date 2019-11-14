package com.chloneda.controller;

import com.chloneda.job.AsyncJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

/**
 * @author chloneda
 * @description: 什么是异步调用？
 * 异步调用是相对于同步调用而言的，同步调用是指程序按预定顺序一步步执行，每一步必须等到上一步执行完后才能执行，
 * 异步调用则无需等待上一步程序执行完即可执行。
 *
 * <p>
 * 如何实现异步调用？
 * 多线程，多线程就是一种实现异步调用的方式，在非Spring目项目中我们要实现异步调用的就是使用多线程方式，
 * 可以自己实现Runable接口或者集成Thread类，或者使用jdk1.5以上提供了的Executors线程池。
 *
 * <p>
 * Spring Boot中则提供了很方便的方式执行异步调用，使用以下注解。
 * @EnableAsync: 启动类添加@EnableAsync注解
 * @Async: 需要异步执行方法上添加@Async注解
 *
 * <p>
 * 如何验证异步执行成功呢？
 * AsyncJob任务类的三个方法如果是同步执行，花费总时间一定大于 6000ms，
 * AsyncJob任务类的三个方法如果是异步执行，花费总时间一定小于 6000ms
 *
 * <p>访问路径: http://localhost:8056/async/runJob</p>
 */
@RestController
@RequestMapping("/async")
public class AsyncJobController {

    @Autowired
    private AsyncJob asyncJob;

    @RequestMapping("/runJob")
    public String runJob() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        Future job1 = asyncJob.runJob1();
        Future job2 = asyncJob.runJob2();
        Future job3 = asyncJob.runJob3();
        long endTime = System.currentTimeMillis();
        while (true) {
            if (job1.isDone() && job2.isDone() && job3.isDone()) {
                // 三个任务都调用完成，退出循环等待
                break;
            }
        }
        String runResult = "AsyncJob任务总耗时: " + (endTime - startTime) + "ms";
        System.out.println(runResult);
        return runResult;
    }

}
