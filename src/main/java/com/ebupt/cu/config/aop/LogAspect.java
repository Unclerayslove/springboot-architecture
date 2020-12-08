package com.ebupt.cu.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LogAspect
 * @Description 日志切面
 * @Author Leipei
 * @Date 2020/11/14 16:30
 * @Version V1.0
 **/
@Aspect
@Component
@Slf4j
public class LogAspect {

    /**
     * * 代表方法返回的任意值
     * 第一个 .* 代表任意类
     * 第二个 .* 代表任意方法
     * (..) 代表任意参数
     */
    @Pointcut("execution(public * com.ebupt.cu.web.controller.*.*(..))")
    public void controllerLog() {
    }

    /**
     * 环绕通知
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("controllerLog()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Long start = System.currentTimeMillis();
        Object[] objects = pjp.getArgs();//获取切点的所有参数
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < objects.length; i++) {
            buffer.append(objects[i] == null ? null : objects[i].toString());
            if (i < objects.length - 1)
                buffer.append(",");
        }

//        Object proceed = pjp.proceed();
        //获取签名的声明类型名称（全类名）+ 签名的方法名 + 执行时间 + 传入的请求参数
        log.info("<<" + pjp.getSignature().getDeclaringTypeName() + "|" + pjp.getSignature().getName() + "|"
                + (System.currentTimeMillis() - start) + "ms|" + buffer.toString() + ">>");
        return pjp.proceed();
    }

    /**
     * * 代表方法返回的任意值
     * 第一个 .* 代表任意类
     * 第二个 .* 代表任意方法
     * (..) 代表任意参数
     */
//    @Pointcut("execution(public * com.ebupt.cu.web.service.*.*(..))")
//    public void serviceLog() {
//    }
//
//    @After(value = "serviceLog()")
//    public void saveLog(JoinPoint jp) throws Throwable {
//        Object[] args = jp.getArgs();
//        List<Object> list = Arrays.asList(args);
//        log.info("[" + jp.getSignature().getName() + "]" + list.toString());
//    }

}
