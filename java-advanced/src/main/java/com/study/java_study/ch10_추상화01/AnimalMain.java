package com.study.java_study.ch10_추상화01;

public class AnimalMain {
    public static void main(String[] args) {

//        Tiger tiger = new Tiger();
//        Dog dog = new Dog();
        Dog dog = new Dog("콩이", 11, "말티즈");
        Animal tiger = new Tiger("옹이", 5, "100");

        dog.move();
        tiger.move();
        // tiger.hunt() Animal로 업캐스팅 되어있어서 사용 불가
        ((Tiger) tiger).hunt(); // 다운캐스팅을 한 모습
        dog.bark();
        System.out.println();

        Animal[] animals = new Animal[3];
        animals[0] = new Animal("이름없는 동물" , 10);
        animals[1] = new Dog("콩이", 11, "말티즈");
        animals[2] = new Tiger("옹이", 5, "100");

        for (Animal animal : animals) {
            animal.move();
        }
        ((Dog)animals[1]).bark();

        System.out.println();
        // 자료형 비교해보기
        for (Animal animal : animals) {
            if (animal instanceof Tiger) {
                Tiger t = (Tiger) animal;
                t.hunt();
//                ((Tiger)animal).hunt();

            } else if (animal instanceof Dog) {
                Dog d = (Dog) animal;
                d.bark();
            } else {
                animal.move();
            }
        }

        System.out.println();
        System.out.println();
        for (Animal animal : animals) {
            if (animal.getClass() == Tiger.class) {
                Tiger t = (Tiger) animal;
                t.hunt();
//                ((Tiger)animal).hunt();

            } else if (animal.getClass() == Dog.class) {
                Dog d = (Dog) animal;
                d.bark();
            }
        }

            String s = "4";
            s.getClass();
            int a = 10;

        System.out.println(s.getClass());
        System.out.println(Tiger.class);
        System.out.println(animals.getClass());
    }
}