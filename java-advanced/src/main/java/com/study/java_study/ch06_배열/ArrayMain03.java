package com.study.java_study.ch06_배열;

public class ArrayMain03 {
    public static void main(String[] args) {

        int[] ns = new int[]{10, 20, 30, 40, 50, 60};

        int num1 = 10;
        int num2 = 20;
        int num3 = 30;
        int num4 = 40;
        int num5 = 50;
        int num6 = 60;

        String[] strArray = new String[5];
        strArray[0] = "가";
        strArray[1] = "나";
        strArray[2] = "다";
        strArray[3] = "라";
        for (String str : strArray) {
            System.out.println(str);
        }

    }
}
