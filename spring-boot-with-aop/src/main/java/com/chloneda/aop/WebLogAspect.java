package com.chloneda.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author chloneda
 * @description: @Aspect 声明这是切面类
 * @Component 告诉Spring需要将其加入到IOC容器
 */

@Aspect
@Component
public class WebLogAspect {

    /**
     * 定义切入点，每一个controller请求方法
     * 说明：
     * 第一个 * 代表任意修饰符及任意返回值.
     * 第二个 * 任意包名
     * 第三个 * 代表任意方法.
     * 第四个 * 定义在web包或者子包
     * 第五个 * 任意方法
     * .. 匹配任意数量的参数.
     */
    @Pointcut("execution(public * com.chloneda.controller.*.*(..))")
    public void webLog() {
        System.out.println("I am webLog！");
    }

    /**
     * 在连接点执行之前执行的通知
     *
     * @param joinPoint
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        System.out.println("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 记录下请求内容
        System.out.println("URL : " + request.getRequestURL().toString());
        System.out.println("HTTP_METHOD : " + request.getMethod());
        System.out.println("IP : " + request.getRemoteAddr());
        System.out.println("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("ARGS : " + Arrays.toString(joinPoint.getArgs()));
        // 获取所有参数方法：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            System.out.println(paraName + ": " + request.getParameter(paraName));
        }
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知）
     */
    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint) {
        // 处理完请求，返回内容
        System.out.println("WebLogAspect.doAfterReturning()");
    }

    /**
     * @description  在连接点执行之后执行的通知（返回通知和异常通知的异常）
     */
    @After("webLog()")
    public void doAfter(){
        System.out.println("WebLogAspect.doAfter()");
    }

    /**
     * @description  在连接点执行之后执行的通知（异常通知）
     */
    @AfterThrowing("webLog()")
    public void doAfterThrowing(){
        System.out.println("WebLogAspect.doAfterThrowing()");
    }
}
