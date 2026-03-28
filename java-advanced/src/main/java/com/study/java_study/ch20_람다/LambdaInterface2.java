package com.study.java_study.ch20_람다;

import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaInterface2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Runnable run = () -> {
            System.out.println("프로그램 실행");

            Integer s = null, t = null;
            Function<String, Integer> fx = n -> Integer.parseInt(n);

            System.out.print("s값 입력:");
            s = fx.apply(sc.nextLine());
            System.out.print("y값 입력:");
            t = fx.apply(sc.nextLine());

            Consumer<Integer> consumer = result -> System.out.println("받은 값 : " + result);
            consumer.accept(s);
            consumer.accept(t);
            Integer ss = fx.andThen(result -> result * 10).apply(String.valueOf(s));
            Integer tt = fx.andThen(result -> result * 10).apply(String.valueOf(t));
            System.out.print("바뀐 값 : " + ss + "\n");
            System.out.print("바뀐 값 : " + tt + "\n");

            Predicate<Integer> even = r -> r % 2 == 0;
            System.out.print( "짝수 ? :" + even.test(ss)+"\n");
            System.out.print( "짝수 ? :" + even.test(tt)+"\n");

            System.out.println("프로그램 종료");

        };
        run.run();


    }
}
