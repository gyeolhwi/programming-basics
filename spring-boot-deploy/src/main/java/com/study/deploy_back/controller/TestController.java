package com.study.deploy_back.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    // 서버 실행 될 때 yml에서 설정한 걸 가지고 올 수 있음
    // (이게 실제 서비스가 운영될 때 배포되는 react의 주소를 가지고와야하기 때문에 변수로 설정)
    @Value("${client.address}")
    private String clientAddress;

    @CrossOrigin(originPatterns = "*")
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok(clientAddress + "테스트이름..?");
    }
}
