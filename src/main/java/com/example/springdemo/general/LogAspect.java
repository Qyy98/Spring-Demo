package com.example.springdemo.general;

import com.example.springdemo.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * LogAspect
 *
 * @Description 接口日志切面
 * @Author QianYiyu
 * @Date 2022/08/23 10:50
 */
@Component
@Aspect
@Slf4j
public class LogAspect {
    @Pointcut("execution(* com.example.springdemo.controller.*.*(..))")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void before(JoinPoint joinPoint) {
        log.info("方法名：" + joinPoint.getSignature().getName());
        log.info("方法参数：" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()", returning = "methodResult")
    public void afterReturning(JoinPoint joinPoint, Object methodResult) {
        log.info("返回结果：" + JsonUtils.obj2String(methodResult));
    }

}
