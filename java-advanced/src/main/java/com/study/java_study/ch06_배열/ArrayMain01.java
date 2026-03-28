package com.study.java_study.ch06_배열;

import java.util.Arrays;

public class ArrayMain01 {
    public static void main(String[] args) {

        int storage = 100;
        int[] nums = new int[storage];
        // 왜 배열을 사용하는가?
        // 함수를 이용할 때 배열에있는 모든것을 통째로 보낼 수 있으며, 필요한 것만 꺼내 쓸 수 있음
        nums[1] = 20;

        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
        System.out.println(nums[3]);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (i+1) * 10;
        }
        for (int num : nums) {
            // 해당배열의 처음부터 끝까지 반복한다
            // 데이터 전체를 가공하거나 다룰 때 유용할 듯
            System.out.print(num);
        }
        int[] arr = new int[10];
        for (int num : arr) {

            System.out.println(num);
        }
        System.out.println();
        System.out.println();


        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                continue;
            }
            int num = nums[i];
            System.out.println(num);
        }

    }
}
