package com.sutdy.SpringSecurity.aspect;

import com.sutdy.SpringSecurity.service.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Slf4j
@Component
@Aspect
public class TimeAspect {

    @Pointcut("@annotation(com.sutdy.SpringSecurity.aspect.annotaion.TimeAop)")
    public void pointcut() {
    }


    @Around("pointcut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();

        StopWatch stopWatch = new StopWatch();

        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();


        String infoPrint = "className(" + signature.getDeclaringType().getSimpleName() + ") MethodName" + signature.getName() + ")";
        String linePrint = "";

        for (int i = 0; i < infoPrint.length(); i++) {
            linePrint += "-";
        }

        log.info("{}", linePrint);
        log.info("{}", infoPrint);
        log.info("Time: {}초", stopWatch.getTotalTimeSeconds());
        log.info("{}", linePrint);

        return result;
    }
}
