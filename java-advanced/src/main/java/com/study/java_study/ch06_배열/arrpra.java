package com.study.java_study.ch06_배열;

import java.util.Arrays;

public class arrpra {
    public static void main(String[] args) {

        int[] a = new int[1];
        int[] b = new int[2];

        a[0] = 1;

        b[0] = a[0];


        a = b;
        System.out.println(a.length);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.toString(b));




    }
}
