package com.study.java_study.ch17_컬렉션;

import java.util.*;

public class StringHashMapMain {
    public static void main(String[] args) {

        HashMap<Integer, String> strMap = new HashMap<>();
        strMap.put(0, "김준일");
        strMap.put(1, "김준이");
        strMap.put(2, "김준삼");
        strMap.put(3, "김준사");

        System.out.println(strMap.get(1));

        Map<String, String> lang = Map.of("java", "자바", "c", "C", "python", "파이썬", "js", "자바스크립트");
        System.out.println(lang);
        System.out.println(lang.get("java"));
        String[] str = {"서식1", "서식2", "서식3", "서식4"};
        Map<String, String> lang2 = Map.of("java", "자바", "c", "C", "python", "파이썬", "js", "자바");

        Set<Map.Entry<String, String>> entries = lang.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            System.out.println("key : " + entry.getKey());
            System.out.println("value : " + entry.getValue());
        }

    }
}