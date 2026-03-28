package com.study.java_study.ch20_람다;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaInterface {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("프로그램 실행");
            System.out.println("프로그램 종료");
        };
        runnable.run();
        Function<String, Integer> fx = s -> Integer.parseInt(s);
        Integer num = fx.apply("10");
        System.out.println(num.getClass());

        // andThen 매개변수는 apply의 반환값을 매개변수로 해서 행동하고 반환해줌
        Integer num2 = fx.andThen(result -> result + 100).apply("10");
        System.out.println(num2);

        Consumer<String> transForm = s -> System.out.println(s + "님 환영합니다");
        transForm.accept("김결휘");

        Supplier<Integer> role = () -> {
            Integer result = num + 999;
            return result;
        };
        System.out.println(role.get());

        Predicate<Integer> even = n -> n % 2 == 0;

        System.out.println(even.test(10));
    }
}
