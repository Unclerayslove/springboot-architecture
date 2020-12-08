package com.ebupt.cu.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @ClassName ThrowableAspect
 * @Description 错误或异常切面
 * @Author Leipei
 * @Date 2020/11/14 16:38
 * @Version V1.0
 **/
@Aspect
@Component
@Slf4j
public class ThrowableAspect {

    @Pointcut("execution(public * com.ebupt.cu.web.controller.*.*(..))")
    public void controllerLog() {
    }

    // 后置异常通知
    @AfterThrowing(throwing = "ex", pointcut = "controllerLog()")
    public void throwsException(JoinPoint jp, Throwable ex) {
        log.info("<<" + jp.getSignature().getDeclaringTypeName() + "|" + jp.getSignature().getName() + "|"
                + jp.getKind() + "|" + ex + ">>");
    }
}
