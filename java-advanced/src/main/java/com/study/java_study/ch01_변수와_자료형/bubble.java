package com.study.java_study.ch01_변수와_자료형;

import java.util.Arrays;

public class bubble {
    public static void main(String[] args) {
        int n = 0 , nn = 0, temp = 0;
        int[] arr = {1,4,2,3,6,8};

        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr.length-1; j++){

                if(arr[j] > arr[i]){
                    temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
                System.out.println("i =" + i + " j = " + j);
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}