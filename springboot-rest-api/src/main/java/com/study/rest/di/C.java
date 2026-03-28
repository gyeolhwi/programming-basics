package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

//    @Autowired(required = false)
    @Autowired
    private D d;


    public void cCall(){

        System.out.println("C객체에서 호출된 메소드");
        d.dCall();
    }
    public void cCall2(){
        System.out.println("C객체에서 호출된 메소드");
        d.dCall();
    }
}
