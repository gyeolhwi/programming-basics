package com.study.rest.di.d;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BB {

    @Autowired
    private CC c;

    public void bCall(){
        c.cCall();
    }

}
