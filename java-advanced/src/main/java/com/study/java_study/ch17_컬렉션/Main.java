package com.study.java_study.ch17_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 원래의 배열
        int[] arr = {1, 2, 3, 4};

        // 배열을 담을 Integer 자료형 배열
        Integer[] arr2 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }
        // 값을 담을 List
        List<Integer> list = new ArrayList<>();
        // 값을 옮겨 줄 List
        List<Integer> list2 = Arrays.asList(arr2); // 얘가 곧 생성,할당 인건가요?
        list.addAll(list2);
        list.add(5);
        System.out.println(list);
        System.out.println(list2);

    }
}