package com.study.java_study.ch18_빌더;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class Data {

    private String data1;
    private int data2;
    private double data3;
    private String data4;

    /*
    자료형의 한계
    public Data(String data1) {
        this.data1 = data1;
    }
    */
}
