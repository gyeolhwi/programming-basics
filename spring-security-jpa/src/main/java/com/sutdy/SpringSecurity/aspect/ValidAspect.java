package com.sutdy.SpringSecurity.aspect;

import com.sutdy.SpringSecurity.dto.request.ReqSignupDto;
import com.sutdy.SpringSecurity.exception.ValidException;
import com.sutdy.SpringSecurity.service.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;

@Slf4j
@Aspect
@Component
public class ValidAspect {


    @Autowired
    private SignupService service;


    @Pointcut("@annotation(com.sutdy.SpringSecurity.aspect.annotaion.ValidAop)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object paramsPrint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object[] args = proceedingJoinPoint.getArgs();

        BeanPropertyBindingResult bindingResult = null; // 컨트롤러에
        log.info("바이이이이인딩리서서서선엇ㅁ넝ㅅ{}", bindingResult);
        // 매개변수가 bindiResult인것만을 찾기
        for (Object arg : args) {
            if (arg.getClass() == BeanPropertyBindingResult.class) {
                // 다운캐스팅해주기
                bindingResult = (BeanPropertyBindingResult) arg;
                break;
            }
        }
        log.info("들어갔나요{}", bindingResult);


        switch (proceedingJoinPoint.getSignature().getName()) {
            case "signup":
                validSignupDto(args, bindingResult);
                break;
        }



        /*
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            System.out.println(fieldError.getField());
            System.out.println(fieldError.getDefaultMessage());
        }
         */

        // 해당 객체에 fieldError이 있으면 생성
        if (bindingResult.hasErrors()) {
            throw new ValidException("유효성 검사 오류", bindingResult.getFieldErrors());
        }

        return proceedingJoinPoint.proceed();
    }

    private void validSignupDto(Object[] args, BeanPropertyBindingResult bindingResult) {
        for (Object arg : args) {

            if (arg.getClass() == ReqSignupDto.class) {
                ReqSignupDto dto = (ReqSignupDto) arg;

                if (!dto.getPassword().equals(dto.getCheckPassword())) {
                    FieldError fieldError = new FieldError("checkPassword", "checkPassword", "비밀번호가 일치하지 않습니다.");
                    bindingResult.addError(fieldError);
                    break;
                }

                if (service.isDuplicateUsername(dto.getUsername())) {
                    FieldError fieldError = new FieldError("username", "username", "이미 존재하는 사용자 이름입니다");
                    bindingResult.addError(fieldError);
                    log.info("에러있나요?{}", bindingResult);
                }
                break;
            }
        }
    }

}
