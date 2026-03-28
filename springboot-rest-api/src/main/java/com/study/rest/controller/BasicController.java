package com.study.rest.controller;

import com.study.rest.dto.*;
import com.study.rest.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Rest API
@Slf4j
@RestController // 전체에 @ResponseBody 붙인겁니다
public class BasicController {
    /*
        REST API
        데이터 통신을 위한 HTTP 요청방식
        HTTP(프로토콜)을 조금 더 잘 쓰기 위해 정의된 개념
        1. 요청에 대한 동작은 무조건 메소드에 따라 정의하자.
            - 데이터 추가(등록)은 POST요청으로 하자,그리고 POST 요청은 JSON데이터로 요청하자.
                데이터 조회는 GET 요청으로하자, 그리고 GET요청은 QueryString(params)으로 요청하자.
                예) 주소? key1=value1&key2=value2
                
            - 데이터 수정은 PUT, Patch 요청으로 하자, JSON으로 요청하자
                PUT 요청과 PATCH 요청의 차이점
                    PUT 요청: 공백 또는 NULL인 데이터도 수정가능하게 만들어야됨
                    PATCH 요청 : 공백 또는 NULL인 데이터는 수정하지 않게 만들어야함

            - 데이터 삭제는 DELETE 요청으로하자 , params로 요청하자

        2. 주소(URL) 요청 메세지(Resource) 자원 작성법
            - URL은 가능한 동사를 사용하지 않는다.

            - 계층 구조로 작성한다.
                /집/주방/가스레인지 , /식당/주방/가스레인지

            - 요청 메소드 마다 작성하는 방법이 다르다.
                상품 등록(POST) /product
                상품 하나(단건) 조회(GET) /product/1(id,key)
                상품 여러개(다건) 조회(GET) /products → 전체조회 /products?page=1&count=30(한페이지 30개씩

            - 상품 수정(PUT) /product/1(id,key)

            - 상품 삭제(DELETE) /product/1(id, key) → 단건, 다건은 위와 같다

        3. 주소는 가능한 대문자를 사용하지 않는다.
    */
    @Autowired
    private ProductService productService;

    @CrossOrigin
    @PostMapping("/basic/student")
    public ResponseEntity<?> addUser(@RequestBody ReqStudentDto dto) {

        log.info("Student : {}", dto);
        return ResponseEntity.badRequest().body("응답 되는 데이터");// ok -> 상태코드 200 badRequest=> 400
    }

    @CrossOrigin
    @PostMapping("/basic/teacher")
    public ResponseEntity<?> addTeacher(@RequestBody ReqTeacherDto dto) {
        log.info("teacher : {}", dto);
        return ResponseEntity.ok().body("응답데이터");
    }
//---------------------------------------------------------------------------------------------------------------------

    @CrossOrigin
    @PostMapping("/api/v1/product")
    public ResponseEntity<?> registerProduct(@RequestBody ProductDto.Register register) {
        log.info("{}", register);
        return ResponseEntity.ok().body(productService.registerProduct(register));
    }
    @CrossOrigin
    @GetMapping("/api/v1/sizes")
    public ResponseEntity<?> sizeListApi(){

        return ResponseEntity.ok().body(productService.getSizeListAll());
//        return ResponseEntity.ok().body(null);
    }

    @CrossOrigin
    @GetMapping("/api/v1/colors")
    public ResponseEntity<?> colorListApi(){

        return ResponseEntity.ok().body(productService.getColorListAll());
    }

    @CrossOrigin
    @PostMapping("/api/v1/size")
    public ResponseEntity<?> registerSize(@RequestBody SizeDto.Info info)  {
        CommonResponseDto responseDto =  productService.registerSize(info);
        log.info("Dto : {}",info);
        return ResponseEntity.ok().body(responseDto);
    }
    @CrossOrigin
    @PostMapping("/api/v1/color")
    public ResponseEntity<?> registerColor(@RequestBody ColorDto.Info info){
        log.info("ColorDto : {}",info);

        return ResponseEntity.ok().body(productService.registerColor(info));
    }
}
