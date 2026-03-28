package com.study.java_study.ch08_클래스03;

import javax.print.attribute.standard.PrinterInfo;

public class ColorMain {
    public static void main(String[] args) {
        // Color 객체 5개 생성  
        // #CA848A, Brandied Apricot
        // #FFBE98, Peach Fuzz
        // #964F4C, Marsala
        // #A78C7B, Almondine
        // #D8C8BD, Almond peach
        // 색상 데이터를 저장한 후 for문 사용 출력

        Color[] colors = new Color[5];
        for (int i = 0; i < colors.length; i++) {
            colors[i] = new Color("#CA848A", "Brandied Apricot");
            colors[i] = new Color("#FFBE98", "Peach Fuzz");
            colors[i] = new Color("#964F4C", "Marsala");
            colors[i] = new Color("#A78C7B", "Almondine");
            colors[i] = new Color("#D8C8BD", "Almond peach");
        }

        Color[] colors1 = {
                new Color("#CA848A", "Brandied Apricot"),
                new Color("#FFBE98", "Peach Fuzz"),
                new Color("#964F4C", "Marsala"),
                new Color("#A78C7B", "Almondine"),
                new Color("#D8C8BD", "Almond peach")
        };


        for (int i = 0; i < colors.length; i++) {
            colors[i].printInfo();
            colors[i].setCode(null);
            colors[i].setName(null);
        }
        System.out.println();
        // 단순출력일 경우해당 forEach 문 사용
        for( Color color : colors){
            color.printInfo();
        }
    }
}
