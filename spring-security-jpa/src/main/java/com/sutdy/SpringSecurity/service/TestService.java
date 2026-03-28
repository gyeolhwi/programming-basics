package com.sutdy.SpringSecurity.service;

import com.sutdy.SpringSecurity.aspect.annotaion.Test2Aop;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    public String aopTest() {
        return "AOP 테스트 입니다.";
    }

    @Test2Aop
    public void aopTest2(String name, int age){
        System.out.println("이름: " + name);
        System.out.println("나이: " + age);
        System.out.println("AOP테스트2입네다이");
    }
    @Test2Aop
    public void aopTest3(String phone, String address){
        System.out.println("AOP테스트3입네다이");
    }
}
