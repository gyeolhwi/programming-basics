package com.study.java_study.ch07_클래스02;

public class StudyMain {
    public static void main(String[] args) {
        StudyA a = new StudyA();
        a.num = 100;
        a.num2 = 1000;
        System.out.println(a.num);
        a = new StudyA(300,400);
        System.out.println(a.num);


        a = new StudyA(1,2);
        System.out.println(a.num);
        // 선언을 하지않고 생성부터 바로 값을 넣을 수 없을까? -> 생성자 설정
        // 생성자 호출
        
        StudyB b = new StudyB();
        b.show();


    }
}
