package com.study.java_study.ch04_제어;

public class Star {
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
//        for (int i = 0; i < 5; i++) {
//            System.out.println("*".repeat(i + 1));
//        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5 - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < 5; i++) {
            int n = 0;
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            while (n < i + 1) {
                System.out.print("*");
                n++;
            }
            System.out.println();
        }
        System.out.println();
        /*
         *****
         ****
         ***
         **
         *

            *
           ***
          *****
         *******
         */
        // 반복문 두개로 풀기
        System.out.println();

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        int n = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" ");
            }
            n++;
            for (int k = 0; k < 5 - i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }


        // 띄어쓰기 3 , 2, 1
        // 반복문 5 번 3번 안에서 1,3,5,7로 만들어주기

        int cnt = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < cnt; j++) {
                System.out.print("*");
            }
            cnt += 2;
            System.out.println();
        }



    }
}
