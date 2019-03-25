package com.clanner.antichat.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author Clanner
 * 接口调用计时器
 */
@Aspect
@Component
public class MethodTimer {

    private ThreadLocal<Long> curStartTime = new ThreadLocal<>();
    private static final Logger logger = LoggerFactory.getLogger(MethodTimer.class);

    /**
     * 统计user包下的所有类的所有方法的耗时
     */
    @Pointcut("execution(* com.clanner.antichat.controller.user.*.*(..))")
    public void point() {
    }

    @Before("point()")
    public void recordStartTime() {
        curStartTime.set(System.currentTimeMillis());
        logger.info("-------------------------------");
    }

    /**
     * 在切点方法（也就是目标方法执行完后调用）
     */
    @AfterReturning("point()")
    public void calExecuteTime(JoinPoint jp) {
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        logger.info(className + "." + methodName + "耗时" + (System.currentTimeMillis() - curStartTime.get()) + "毫秒");
    }

    /**
     * 在目标方法抛出异常后调用
     */
    @AfterThrowing("point()")
    public void somethingWrong(JoinPoint jp) {
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        logger.error(className + "." + methodName + "有异常");
    }

    /**
     * 目标方法抛出异常或正常执行完毕后都会调用
     */
    @After("point()")
    public void complete(JoinPoint jp) {
        String className = jp.getTarget().getClass().getName();
        String methodName = jp.getSignature().getName();
        logger.info(className + "." + methodName + "执行完毕");
    }
}
