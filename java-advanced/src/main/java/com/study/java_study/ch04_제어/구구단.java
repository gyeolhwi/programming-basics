package com.study.java_study.ch04_제어;

import java.awt.print.Printable;
import java.util.Arrays;

public class 구구단 {
    public static void main(String[] args) {
        /*
        [2단]
        .
        [3단]

         */
        for (int i = 0; i < 8; i++) {
            int dan = i + 2;
            System.out.println("[" + dan + "단]");
            for (int j = 0; j < 9; j++) {
                int num = j + 1;
                System.out.println(dan + " x " + num + " = " + (dan * num));
            }
        }
    }
}