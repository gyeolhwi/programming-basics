package com.study.java_study.ch04_제어;

public class StringUtils {
    // 단일책임원칙
    boolean isEmpty(String str) {
        if (str == null) {
            return true;
        }
        return str.equals("");

        // null 먼저 확인하기
//        return str == null || str.equals("");
        // 안 그러면 오류가 뜨거나 예외발생
//        return str.equals("") || str == null;
    }


}
