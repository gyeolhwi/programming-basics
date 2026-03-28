package com.study.java_study.ch03_함수;

public class FunctionTest02 {
    int getAddData(int a, int b ){
        FunctionTest03 functionTest03 = new FunctionTest03();
        System.out.printf("a와 b를 받긴 함 %d %d", a , b);

        return functionTest03.add(a,b);
    }
}