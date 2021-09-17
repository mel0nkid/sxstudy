package com.melon.sx.study.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志AOP
 *
 * @author imelonkid
 * @date 2021/09/17 17:08
 **/
@Aspect
@Component
public class DaoLogAcpect {

    private Logger logger = LoggerFactory.getLogger(DaoLogAcpect.class);

    private static final String PREFIX = "query[{}]";
    private static final String RET_PREFIX = "ret={}";

    /**
     * 定义切入点，切入点为com.example.aop下的所有函数
     */
    @Pointcut("execution(public * com.melon.sx.study.dao..*.*(..))")
    public void daoLog() {
    }

    long startTimestamp = 0;

    /**
     * 前置通知：在连接点之前执行的通知
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before("daoLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        startTimestamp = System.currentTimeMillis();
    }

    @AfterReturning(returning = "ret", pointcut = "daoLog()")
    public void doAfterReturning(JoinPoint joinPoint, Object ret) throws Throwable {
        // 接收到请求，记录请求内容
        Object[] args = joinPoint.getArgs();
        String name = joinPoint.getSignature().getName();

        // time cost
        long cost = System.currentTimeMillis() - startTimestamp;
        if (args == null || args.length < 1) {
            logger.info(PREFIX + "args:[empty...][{}]" + RET_PREFIX, name, ret, cost);
            return;
        }

        logger.info(PREFIX + "args:{}[{}]" + RET_PREFIX, name, Arrays.toString(joinPoint.getArgs()),
            ret, cost);
    }
}
