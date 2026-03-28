package com.sutdy.SpringSecurity.controller;

import com.sutdy.SpringSecurity.exception.ValidException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;

@RestControllerAdvice // ioc안에서 터진 예외만을 낚아챌 수 있음
public class ExceptionControllerAdvice {


    @ExceptionHandler(ValidException.class) // 던지는 걸 받는 핸들러
    public ResponseEntity<?> validException(ValidException e) {
        return ResponseEntity.badRequest().body(e.getFieldErrors());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<?> usernameNotFoundExceptionException(UsernameNotFoundException e) {
        return ResponseEntity.badRequest().body(Set.of(new FieldError("authentication","authentication",e.getMessage())));
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<?> badCredentialsException(BadCredentialsException e) {
        return ResponseEntity.badRequest().body(new FieldError("authentication", "authentication",e.getMessage()));
    }
}
