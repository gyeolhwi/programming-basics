package com.study.java_study.ch04_제어;

import java.util.Random;
import java.util.Scanner;

public class While01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int num = random.nextInt(5) + 1; // 0 ~ 9 중 랜덤
        while (true) {
            System.out.print("입력 : ");
            int answer = scanner.nextInt();
            scanner.nextLine();
            if (num == answer) {
                System.out.println("정답 : " + answer);
                break;
            }
            System.out.println("땡 !");
        }


    }
}
