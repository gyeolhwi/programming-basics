package com.study.rest.di;

import org.springframework.stereotype.Component;

@Component
public class D {

    public void dCall(){
        System.out.println("D객체에서 호출된 메소드");
    }
}
