package com.study.java_study.ch02_클래스;


import com.study.java_study.ch03_함수.FunctionMain01;

public class ObjectMain {
    public static void main(String[] args) {
        int a = 10;
        // 자료형을 새로 만들겠다
        ObjectA objectA = new ObjectA();    // 같은 생성자라도 주소는 다르게 부여됨
        ObjectA objectA2 = new ObjectA();
        System.out.println(a);
        System.out.println(objectA);
        System.out.println(objectA2);

        objectA.num = 20;
        objectA2.num = 30;

        System.out.println(objectA.num);
        System.out.println(objectA2.num);

        System.out.println(objectA.name);
    }
}
