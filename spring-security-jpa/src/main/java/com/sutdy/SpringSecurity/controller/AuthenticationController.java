package com.sutdy.SpringSecurity.controller;


import com.sutdy.SpringSecurity.aspect.annotaion.ParamsAop;
import com.sutdy.SpringSecurity.aspect.annotaion.ValidAop;
import com.sutdy.SpringSecurity.dto.request.ReqSigninDto;
import com.sutdy.SpringSecurity.dto.request.ReqSignupDto;
import com.sutdy.SpringSecurity.service.SigninService;
import com.sutdy.SpringSecurity.service.SignupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private SignupService signupService;

    @Autowired
    private SigninService signinService;

    @ValidAop
    @ParamsAop
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody ReqSignupDto dto, BindingResult bindingResult) {
        // @Valid => 정규식체크 바로해줌
        return ResponseEntity.created(null).body(signupService.signup(dto));
    }

    @ValidAop
    @ParamsAop
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@Valid @RequestBody ReqSigninDto dto, BindingResult bindingResult) {

        return ResponseEntity.ok().body(signinService.signin(dto));
    }
}
