package com.study.java_study.ch18_빌더;

public class DataMain {
    public static void main(String[] args) {
        Data data = new Data("a", 10, 10.5, "b");
        Data data2 = new Data();

        DataEntity dataEntity = DataEntity.builder()
                .data2(10)
                .data1("a")
                .data4("b")
                .build();
    }

    DataEntity2 dataEntity2 = DataEntity2.builder()
            .data1("a")
            .data2(20)
            .data3(3.14)
            .data4("b")
            .build();
}
