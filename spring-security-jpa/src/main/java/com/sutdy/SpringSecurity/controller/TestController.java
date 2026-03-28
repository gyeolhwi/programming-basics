package com.sutdy.SpringSecurity.controller;

import com.sutdy.SpringSecurity.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("/test")
    public ResponseEntity<?> get(){
        System.out.println("get메소드 호출");
//        System.out.println(testService.aopTest());

        testService.aopTest2("김결휘",26);
        testService.aopTest3("010-6818-5091","부산시 배고프다구");

        System.out.println("get메소드 리턴되기 직전");
        return ResponseEntity.ok("확인");
    }
}
