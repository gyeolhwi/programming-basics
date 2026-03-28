package com.study.java_study.ch03_함수;

public class FunctionTestMain {
    public static void main(String[] args) {

        FunctionTest01 functionTest01 = new FunctionTest01();
        functionTest01.printResult();
        System.out.println("Result 도출 후 출력구문");

        System.out.println(a(10,20));
    }
    static int a(int n , int nn){
            return n + nn;
        }
}
