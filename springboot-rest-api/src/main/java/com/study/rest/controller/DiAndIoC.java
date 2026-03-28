/*
package com.study.rest.controller;

import com.study.rest.di.A;
import com.study.rest.di.B;
import com.study.rest.di.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DiAndIoC {


    @ResponseBody
    @GetMapping("/di")
    public Object di() {

        // A 가 B를 의존하는 관계
        B b = new B();
        A a = new A(b); //외부에서 의존성을 주입함으로써 결합성은 낮은상태

        a.aCall();

        return null;
    }

    @Autowired
    private C c;

    @ResponseBody
    @GetMapping("/ioc")
    public Object ioc() {
        c.cCall();
        return null;
    }
    
    // IOC컨테이너 등록 , 구현클래스 선언
    @Autowired
    @Qualifier("ts")
    private TestService testService1;

    @Autowired
    @Qualifier("nts")
    private TestService testService2;

    @ResponseBody
    @GetMapping("/test")
    public Object startTest(@RequestParam String type) {

        if ("old".equals(type)) {
//            testService1.test();
        } else {
//            testService2.test();
        }
//        TestService test = new TestServiceImpl();
//        TestService test2 = new NewTestServiceImpl();
        return "hi";
    }
    @GetMapping("/ttt")
    public String ssss(){

        return " ";
    }

}

 */