package com.study.java_study.ch03_함수;

public class FunctionMain01 {
    public static void main(String[] args) {
        //Function01 클래스에 있는 것들을 사용하기위해서 생성한다
        Function01 fnc = new Function01();
        int result = fnc.add(10,2);
        int result2 = fnc.add(100,50);
        fnc.add(10,2);

        System.out.println(result);
        System.out.println(result2);
        System.out.println();

        int result3 = fnc.sub(100,20);
        int result4 = fnc.sub(5,2);
        System.out.println(result3);
        System.out.println(result4);


    }
}
