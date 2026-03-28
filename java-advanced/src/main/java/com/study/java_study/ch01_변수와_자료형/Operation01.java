package com.study.java_study.ch01_변수와_자료형;

public class Operation01 {
    public static void main(String[] args) {
        // 연산자 (산술 , 논리, 관계 , 증감)

        int num1 = 10 + 20;
        int num2 = (int)9.0 / 2;
        double num3 = 9.0 / 2;
        int num4 = 9 % 2;

        boolean no = 5 % 2 == 0;

        System.out.println(num2);
        System.out.println(num3);

        System.out.println(num4);
        int i = 0;
        System.out.println();

        System.out.println(i++);

        System.out.println(i);
        i += 1;
        System.out.println(i);
        System.out.println(++i);

        System.out.println(i++);
        System.out.println(i);

        System.out.println();
        System.out.println(--i);
        System.out.println(i--);
        System.out.println(i);
        
        // 논리연산자
        // true = 1 / false = 0
        // && AND(곱) ,|| OR(합) , != NOT(부정) , XOR
        System.out.println( true && true);
        System.out.println(true && false);
        System.out.println();

        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || false);

        System.out.println();
        System.out.println(!true && true);
        System.out.println(!(true && false));


        System.out.println("관계");
        // 관계
        System.out.println(3 > 2 && 1 == 1);
        System.out.println(1 != 1);

        // 조건연산자 & 삼항연산자
        System.out.println(3 > 2 ? "참" : "거짓");
        int x = 10, y = 2;

        // 삼항연산자는 두 결과값의 자료형이 일치해야한다
//      String result = x % y == 0 ?  x+"은 "+y+"의 배수입니다": x+"은 "+y+"의 배수가 아닙니다";
        String result = x % y == 0 ?  String.valueOf(1): String.valueOf(2);
        System.out.println(result);
        
        // 형변환
        String result2 = "" + 10 / 2;
        System.out.println(result2);

        // 복합대입연산자
        int number = 10;
        number += 5; // ==  number = number +5;
        number -= 1;
        number *= 2;
        number /= 2;
        number %= 2;
        System.out.println(number);






    }
}

