package com.study.java_study.ch04_제어;

public class TStar {
    public static void main(String[] args) {

        /*
     *
    **
   ***
  ****
 *****
         */
        int limit = 5;
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 1 + i; j++) {
                System.out.print("*");
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
 */
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < limit - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        System.out.println();
/*
   *
  ***
 *****
*******
 */
        for (int i = 0; i< limit; i++){
            for (int j = 0; j < limit - 1 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < (i + 1) * 2 - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }



    }
}
