package com.study.java_study.ch06_배열;

import java.util.Arrays;

public class ArrayMain02 {
    public static void main(String[] args) {

        String a = "김준일";
        String b = new String("김준일");

        System.out.println(a);
        System.out.println(b);

        System.out.println(a == "김준일");
        System.out.println(b == "김준일");

        System.out.println();System.out.println();System.out.println();

        String[] names = new String[2];
        names[0] = "김준일";
        names[1] = new String("김준일");

        String[] names2 = {"김준일", new String("김준일")};

        System.out.println(names[1]);
        System.out.println(names2[1]);

        System.out.println(names2);

        System.out.println();System.out.println();System.out.println();

        // 안에물건은 같은 택배상자 이지만 보낼 주소는 다름.
        System.out.println(names[1] == names2[1]);

        int n = 10;
        n = n + 1;
        n++;
        n += 1;

        System.out.println(new String[2]);
        System.out.println(new String[] {"a","b"});

        int[] ar = new int[5];

        for(int nn : ar){

        }



    }
}
