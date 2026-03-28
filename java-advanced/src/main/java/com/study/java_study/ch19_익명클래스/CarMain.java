package com.study.java_study.ch19_익명클래스;

public class CarMain {
    public static void main(String[] args) {

        // 하나의 객체를 만들긴 할 건데 재사용은 안 할 경우
        KiaCar kiaCar = new KiaCar("k8", "화이트");
        System.out.println(kiaCar);

        /*
            추상 설계도에서 실존하는 걸 만든다(클래스) -> 인스턴스를 생성한다
            KiaCar의 경우는 실존하는 틀
            익명 -> 일회용 같은 거
        */
        // 클래스 필요없이 바로 구현
        AbstractCar abstractCar = new AbstractCar("내가만든 자동차", "내심장의 색깔은 블뤡") {
            @Override
            public void createCar() {
                System.out.println("한번 만들어봄.");
            }

            @Override
            public void showCar() {
                System.out.println("자동차 정보");
            }
        };
        System.out.println(abstractCar);
        abstractCar.createCar();
        abstractCar.showCar();

    }
}
