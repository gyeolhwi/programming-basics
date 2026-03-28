package com.study.java_study.ch11_추상화02;

public class AnimalMain {
    public static void main(String[] args) {
//        Animal a = new Animal();
        Animal[] animals = new Animal[10]; // 배열을 생성하는 것은 그저 공간을 만드는 것이기 때문에 다르게 통용된다
        

        for (int i = 0; i < animals.length; i++) {
            animals[i] = i % 2 == 0 ? new Dog() : new Tiger();
        }
        int cnt = 0;
        for (Animal animal : animals) {
            System.out.print(cnt++ + " ");
            animal.move();
        }
    }
}
