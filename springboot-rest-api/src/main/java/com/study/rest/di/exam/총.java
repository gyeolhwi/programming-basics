package com.study.rest.di.exam;

import org.springframework.stereotype.Component;

@Component()
public class 총 implements 무기{
    @Override
    public void 공격() {
        System.out.println("총을 쏜다");
    }
}
