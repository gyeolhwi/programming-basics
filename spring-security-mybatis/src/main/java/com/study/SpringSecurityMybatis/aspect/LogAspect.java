package com.study.SpringSecurityMybatis.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LogAspect {


    @Pointcut("@annotation(com.study.SpringSecurityMybatis.aspect.annotation.LogAop)")
    private void pointCut(){}

    @Around("pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws  Throwable{

        log.info(" >>> method : {}, args:{} <<<", proceedingJoinPoint.getSignature().getName(),proceedingJoinPoint.getArgs());
        return proceedingJoinPoint.proceed();
    }
}
