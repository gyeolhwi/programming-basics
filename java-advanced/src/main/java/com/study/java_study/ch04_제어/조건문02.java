package com.study.java_study.ch04_제어;

public class 조건문02 {
    public static void main(String[] args) {
        // 공백 마저도 리터럴임 주소값이 존재한다는 거
        String text = new String();
        String name = "";
        String phone = ""; // 값의 자료형 null

        StringUtils stringUtils = new StringUtils();


        if (stringUtils.isEmpty(name)) {
            System.out.println("name 비어있음");
            return;
        }
        if (stringUtils.isEmpty(phone)) {
            System.out.println("phone 비어있음");
            return;
        }
        if (stringUtils.isEmpty(text)) {
            System.out.println("text 비어있음");
            return;
        }
        System.out.println("oh");

    }
}