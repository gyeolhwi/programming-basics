package com.study.java_study.ch05_입력;

import java.util.Scanner;

public class 입력01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("a: ");
        String a = scanner.next();
        System.out.println("a: " + a);

        System.out.print("b: ");
        String b = scanner.nextLine();
        System.out.println("b: " + b);





    }
}
