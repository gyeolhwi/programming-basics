package com.study.java_study.ch04_제어;

public class For01 {
    public static void main(String[] args) {
        // 선언문? 조건 후처리
        int n = 10000;
        for (int i = 0; i < 10000; i++) {
            System.out.println(n--);
        }
    }
}
