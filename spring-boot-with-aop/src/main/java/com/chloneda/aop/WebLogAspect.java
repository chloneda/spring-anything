package com.chloneda.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Enumeration;

/**
 * @author chloneda
 * @description: AOP中相关的概念:AOP，面向切面编程，是对OOP的补充。在运行时，动态的将代码切入到类的指定方法或者指定位置上的编程思想，就是面向切面的编程
 * <p>
 * Aspect： 切面，一个关注点的模块化，这个关注点可能会横切多个对象。
 * JoinPoint： 连接点，在程序执行过程中某个特定的点，比如某方法调用的时候或者处理异常的时候。在Spring AOP中，一个连接点总是表示一个方法的执行。
 * Advice： 通知，在切面的某个特定的连接点上执行的动作。
 * Pointcut： 切点，匹配连接点的断言。通知和一个切入点表达式关联，并在满足这个切入点的连接点上运行（例如，当执行某个特定名称的方法时）。
 * 切入点表达式如何和连接点匹配是AOP的核心：Spring缺省使用AspectJ切入点语法。
 * </p>
 * @Aspect 声明这是切面类
 * @Component 告诉Spring需要将其加入到IOC容器
 */
@Aspect
@Component
public class WebLogAspect {

    /**
     * <p>
     * Advice通知类型相关概念
     * 前置通知（Before advice）：在某连接点之前执行的通知，但这个通知不能阻止连接点之前的执行流程（除非它抛出一个异常）。
     * 后置通知（After returning advice）：在某连接点正常完成后执行的通知：例如，一个方法没有抛出任何异常，正常返回。
     * 异常通知（After throwing advice）：在方法抛出异常退出时执行的通知。
     * 最终通知（After (finally) advice）：当某连接点退出的时候执行的通知（不论是正常返回还是异常退出）。
     * 环绕通知（Around Advice）：包围一个连接点的通知，如方法调用。这是最强大的一种通知类型。环绕通知可以在方法调用前后完成自定义的行为。</p>
     */

    /**
     * 定义切入点，切入点为每一个controller请求方法
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
     * @param joinPoint
     * @desc 前置通知, 在连接点执行之前执行的通知
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
        // 接收到请求，记录请求内容
        System.out.println("WebLogAspect.doBefore()");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 输出请求内容
        System.out.println("    URL : " + request.getRequestURL().toString());
        System.out.println("    HTTP_METHOD : " + request.getMethod());
        System.out.println("    HOST_IP : " + request.getRemoteAddr());
        System.out.println("    CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        System.out.println("    PARAMETERS : " + Arrays.toString(joinPoint.getArgs()));
        // 获取所有参数方法：
        Enumeration<String> enu = request.getParameterNames();
        while (enu.hasMoreElements()) {
            String paraName = enu.nextElement();
            System.out.println(paraName + ": " + request.getParameter(paraName));
        }
    }

    /**
     * @desc 后置通知, 在连接点执行之后执行的通知
     */
    @AfterReturning("webLog()")
    public void doAfterReturning(JoinPoint joinPoint) {
        // 处理完请求，返回内容
        System.out.println("WebLogAspect.doAfterReturning()");
    }

    /**
     * @desc 最终通知, 当某连接点退出的时候执行的通知
     */
    @After("webLog()")
    public void doAfter() {
        System.out.println("WebLogAspect.doAfter()");
    }

    /**
     * @desc 异常通知, 在连接点执行之后执行的通知
     */
    @AfterThrowing("webLog()")
    public void doAfterThrowing() {
        System.out.println("WebLogAspect.doAfterThrowing()");
    }

    /**
     * @desc 环绕通知, 包围一个连接点的通知
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        long startTime = System.currentTimeMillis();
        // 方法的返回值
        Object obj = pjp.proceed();
        System.out.println("WebLogAspect.doAround()! 耗时: " + (System.currentTimeMillis() - startTime) + "ms");
        return obj;
    }

}
