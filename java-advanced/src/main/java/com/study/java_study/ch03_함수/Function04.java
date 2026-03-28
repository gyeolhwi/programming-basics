package com.study.java_study.ch03_함수;

public class Function04 {
    void add(int a, int b){
        System.out.println(a + b);
    }
    void add(int a, String b){
        int c = Integer.parseInt(b);
        System.out.println(a + c);
    }
    // 파라미터들의 자료형에 따라서 오버로딩이 가능한데

    void add(int a, int b, int c){
        System.out.println(a + b + c);
    }
    // 매개변수가 세개일 때 판단하는 방법
}
