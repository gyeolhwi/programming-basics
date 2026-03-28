package com.study.rest.di.exam;

import org.springframework.stereotype.Component;

@Component
public class 물공방패 implements  방패{
    @Override
    public void 방어() {
        System.out.println("물리막습니다");
    }
}
