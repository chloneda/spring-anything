package com.magic.springboot.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by chl
 * Description:
 */
@Aspect
@Component
public class ServiceAop {
    private static Logger logger = LoggerFactory.getLogger(ServiceAop.class);

    private ThreadLocal<Long> timeLocal = new ThreadLocal<Long>();

    @Pointcut("execution(public * com.magic.springboot.service.*.*(..))")
    public void webRequestLog() {}

    @Before("webRequestLog()")
    public void doBefore(JoinPoint joinPoint) {
        timeLocal.set(System.currentTimeMillis());
    }

    @AfterReturning(returning = "result", pointcut = "webRequestLog()")
    public void doAfterReturning(Object result) {
        long startTime = timeLocal.get();
        logger.info("花费的时间为:"+(System.currentTimeMillis()-startTime)+"毫秒");
    }

    @Around("webRequestLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object o = null;

        o = pjp.proceed();

        return o;
    }
}
