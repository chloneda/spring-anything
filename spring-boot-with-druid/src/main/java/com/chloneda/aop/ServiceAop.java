package com.chloneda.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Created by chloneda
 * @Description:
 */
@Aspect
@Component
public class ServiceAop {
    private static final Logger logger = LoggerFactory.getLogger(ServiceAop.class);

    @Pointcut("execution(public * com.magic.springboot.service.*.*(..))")
    public void webRequestLog() {
    }

    @Before("webRequestLog()")
    public void doBefore(JoinPoint joinPoint) {
        ThreadLocal threadLocal;
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String beanName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        String uri = request.getRequestURI();
        String remoteAddr = getIpAddr(request);
        String sessionId = request.getSession().getId();
        String user = (String) request.getSession().getAttribute("user");
        String method = request.getMethod();
        String params = "";
    }

    @AfterReturning(returning = "result", pointcut = "webRequestLog()")
    public void doAfterReturning(Object result) {

    }

    @Around("webRequestLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("ServiceAop------方法环绕start------");
        Object o = null;
        System.out.println("ServiceAop------before------");
        o = pjp.proceed();
        System.out.println("ServiceAop------after------");
        return o;
    }

    /**
     * 获取登录用户远程主机ip地址
     *
     * @param request
     * @return
     */
    private String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 请求参数拼装
     *
     * @param paramsArray
     * @return
     */
    private String argsArrayToString(Object[] paramsArray) {
        String params = "";
        if (paramsArray != null && paramsArray.length > 0) {
            for (int i = 0; i < paramsArray.length; i++) {
                Object jsonObj = paramsArray[i];
                params += jsonObj.toString() + " ";
            }
        }
        return params.trim();
    }
}
