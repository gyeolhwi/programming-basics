package com.study.java_study.ch18_빌더;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> numbers2 = new ArrayList<>();
/*
        for (int i = 0; i < numbers.size(); i++) {
            numbers2.add(numbers.get(i) * 2);
        }
        System.out.println(numbers2);
*/
/*
        for(Integer n : numbers){
            numbers2.add(n * 2);
        }
        System.out.println(numbers2);
*/
        // stream 으로 해보기
        List<Integer> numbers3 = numbers.stream().map( n -> n * 2).collect(Collectors.toList());
        // 해당 객체를 stream객체로 바꿔라 stream은 map메서드를 사용할 수 있다 -> 람다식 사용  후 컬렉션으로바꿔라 마지막으로 다시 리스트로 넘겨주기
        System.out.println(numbers3);

    }
}