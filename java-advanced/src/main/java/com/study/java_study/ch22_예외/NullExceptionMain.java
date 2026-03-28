package com.study.java_study.ch22_예외;

import java.util.ArrayList;
import java.util.List;

public class NullExceptionMain {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("신선애");
        names.add("김동인");
        names.add("백승주");
        names.add(null);


        try {
//            names.forEach(name -> System.out.println(name.toString()));
            for (int i = 0; i < 6; i++) {
                System.out.println(names.get(i).toString());
            }
            System.out.println("트라이 마지막");
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println("예외에 관계없이 실행");
        }
        System.out.println("off");
    }

}
