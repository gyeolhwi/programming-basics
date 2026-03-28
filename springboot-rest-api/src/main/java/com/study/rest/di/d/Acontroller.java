package com.study.rest.di.d;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Acontroller {

    @Autowired
    private BB b;

    @ResponseBody
    @GetMapping("/test/test")
    public Object m(){
        b.bCall();
        return null;
    }

}
