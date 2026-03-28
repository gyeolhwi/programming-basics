package com.sutdy.SpringSecurity.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 2)
public class TestAspect {

    @Pointcut("execution(* com.sutdy.SpringSecurity.service.TestService.aop*(..))")
    private void pointCut()/*함수명*/ {}

    @Around("pointCut()") //호출형태
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("전처리");
        Object result = proceedingJoinPoint.proceed(); // 핵심기능
        System.out.println("후처리");

        return result;
    }

}
