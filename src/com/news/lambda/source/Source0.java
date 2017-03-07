package com.news.lambda.source;

/**
 *
 */

public class Source0 {

    public static void main(String[] args) {
        /*
         * 0. Пример использования лямбд для реализации отложенного вызова:
         */
        Runnable run = () -> System.out.println("\n-------------------------\nПример использования лямбд для реализации отложенного вызова!\n-------------------------");
        new Thread(run).start();

        /*
         * 1. обычный интерфейс:
         */
        MyFace my = new MyClas();
        my.hello();

        /*
         * 2. интерфейс с дефолтным методом:
         */
        MyFace1 my1 = new MyClas1();
        my1.hello();

        /*
         * 3. функциональным интерфейс:
         */
//        MyFace2 my2 = () -> { System.out.println("Hello Face!"); };
        MyFace2 my2 = () -> System.out.println("Hello Face!");
        my2.hello();


        String[] arr = {"A","B","C"};
        MyFace22 my22_1 = (String arg) -> System.out.print(arg);
        for (String a:arr) my22_1.print(a);

        System.out.println();

        MyFace222 my22_2 = (String[] aaa) -> { for (String a:aaa) System.out.print(a); };
        my22_2.print(arr);
    }

}

/*
 * 1. обычный интерфейс:
 */
interface MyFace {
    void hello();
}

class MyClas implements MyFace {
    public void hello(){
        System.out.println("Hello!");
    }
}

/*
 * 2. интерфейс с дефолтным методом:
 */
interface MyFace1 {
    default void hello(){
        System.out.println("Hello Clas!");
    }
}

class MyClas1 implements MyFace1 {
}

interface MyFace2 {
    void hello();
}

/*
 * 3. функциональным интерфейс:
 */
interface MyFace22 {
    void print(String arg);
}

interface MyFace222 {
    void print(String[] args);
}
