package com.study.java_study.ch03_함수;

public class FunctionMain02 {
    public static void main(String[] args) {
        System.out.println(10);

        Function02 fx = new Function02(); // 주소 할당

        fx.fx01();
        // 다운캐스팅 또는 형변환으로 자료형만 맞춰주면 뭐든 들어갈 수 있음
        String strnum = "15";
        fx.fx02(Integer.parseInt(strnum),(int)20.1);
        System.out.println(fx);

        fx.fx02(10,29);


        System.out.println(fx.빙수기계("참치",3)+" 나왔습니다");
        String 빙수 = fx.빙수기계("뜨거운",1203102301);
        System.out.println(빙수);

    }
}
