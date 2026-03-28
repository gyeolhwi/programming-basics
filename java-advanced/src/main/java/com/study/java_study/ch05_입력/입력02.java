package com.study.java_study.ch05_입력;

import java.util.Scanner;

public class 입력02 {
    public static void main(String[] args) {
        int age = 0;
//              nextInt
        String name = null, address = null, gender = null, phone = null;
//                    next           nextLine        next           nextLine

        /*
        이름 : 김결휘
        나이 : 26
        주소 : 부산 사하구 제석로
        성별 : 남
        연락처 : 010 - 6818 - 5091
         */
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름 :");
        name = scanner.next();
        scanner.nextLine();
        System.out.print("나이 :");
        age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("주소 :");
        address = scanner.nextLine();
        System.out.print("성별 :");
        gender = scanner.next();
        scanner.nextLine();
        System.out.print("연락처 :");
        phone = scanner.nextLine();

        System.out.printf("이름 : %s \n나이 : %d\n주소 : %s\n성별 : %s\n연락처 : %s", name, age, address, gender, phone);
        System.out.println();

        System.out.println("이름 " + name);
        System.out.println("나이 " + age);
        System.out.println("주소 " + address);
        System.out.println("성별 " + gender);
        System.out.println("연락처 " + phone);
    }
}
