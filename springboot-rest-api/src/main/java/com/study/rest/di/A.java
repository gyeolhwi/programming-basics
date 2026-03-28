package com.study.rest.di;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class A {
    private B b;

    public void aCall(){
        System.out.println("A객체에서 호출된 메소드");
        b.bCall();
    }
}
