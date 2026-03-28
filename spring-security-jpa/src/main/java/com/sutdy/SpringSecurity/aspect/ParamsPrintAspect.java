package com.sutdy.SpringSecurity.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ParamsPrintAspect {

//    @Pointcut("exectuion(* com.sutdy.SpringSecurity.service.TestService.)")
//    public void exPointCut() {
//    }

    @Pointcut("@annotation(com.sutdy.SpringSecurity.aspect.annotaion.ParamsAop)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object paramsPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        CodeSignature signature = (CodeSignature) proceedingJoinPoint.getSignature();

        log.info("======{}.{}======",
                signature.getDeclaringType().getSimpleName(), // class경로의.getSimpleName 클래스명만 뽑기
                signature.getName()); // 메소드명

        String[] paramNames = signature.getParameterNames();
        Object[] args = proceedingJoinPoint.getArgs();
        String infoPrint = "className(" + signature.getDeclaringType().getSimpleName() + ") MethodName" + signature.getName() + ")";
        String linePrint = "";

        for (int i = 0; i < infoPrint.length(); i++) {
            linePrint += "-";
        }

        log.info("{}", linePrint);
        log.info("{}", infoPrint);
        for (int i = 0; i < paramNames.length; i++) {
            log.info("{} >>> {}", paramNames[i], args[i]);
        }
        log.info("{}", linePrint);

        return proceedingJoinPoint.proceed();
    }

}
