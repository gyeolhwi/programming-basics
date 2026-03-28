package com.sutdy.SpringSecurity.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(value = 1)
public class TestAspect2 {
    @Pointcut("@annotation(com.sutdy.SpringSecurity.aspect.annotaion.Test2Aop)")
    public void pointCut() {}


    @Around("pointCut()") //호출형태
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        /*
        for(Object obj : proceedingJoinPoint.getArgs()){
            System.out.println(obj);
        }
        */

//        Signature signature = proceedingJoinPoint.getSignature();
        CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();
        System.out.println(signature.getName());
        System.out.println(signature.getDeclaringTypeName());

        Object[] args = proceedingJoinPoint.getArgs();
        String[] paramNames = signature.getParameterNames();
        for (int i = 0; i < args.length; i++) {
            System.out.println(paramNames[i] + ":" + args[i]);
        }

        System.out.println("전처리2");
        Object result = proceedingJoinPoint.proceed(); // 핵심기능
        System.out.println("후처리2");

        return result;
    }

}
