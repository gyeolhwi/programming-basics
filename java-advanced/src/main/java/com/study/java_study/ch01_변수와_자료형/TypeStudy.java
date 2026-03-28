package com.study.java_study.ch01_변수와_자료형;
public class TypeStudy {

    public static void main(String[] args) {
        /* [ 일반 자료형 ]
         *  1. 논리
         *  2. 정수 (int 21억 초과 시 오류발생 )
         *  3. 숫자(실수)
         *  4. 문자
         *  5. 문자열 -> 클래스자료형
         *  형변환 ( up & down casting )
         *  명시적형변환
         */
//        1
        boolean a = false;
        boolean b = true;
//        2
        int n = 1000000000;
       long l = 10000000000l;
//        3
        double e = 3.14;
         float f = 0;
//        4
        char c = '가';
//        5
        String g = "가나";

        // DownCasting
        System.out.println(c);
        System.out.println((int)c);
        System.out.println((char)44032);
        System.out.println("\uAC01");

        System.out.println((char)((int)c+1));

//      형 변환 순서 문자 -> 정수 -> 실수

        double num = 3.14;
        System.out.println(num);
        
//      명시적 형 변환 downcasting
        int num2 = (int)num; // 3
        char cc = (char)num2;
//      묵시적 형 변환 upcasting
        double num3 = num2; // 정수를 실수에다 넣음 ( 데이터 손실이 없기 때문에 오류없이 선언 가능)
        System.out.println(cc+1);

        System.out.println((int)num);
        System.out.println(num2);


        System.out.println(cc);
    }
}