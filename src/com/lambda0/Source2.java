package com.lambda0;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 19/05/2015
 * {@link http://habrahabr.ru/post/216431/}
 ******************************************************
 * Новое в Java 8
 */
public class Source2 {

    public static void main(String[] args) {

        Formula formula = new Formula();
        System.out.println( formula.calculate1(16) );
        System.out.println( formula.calculate2(16) );
        System.out.println( formula.sqrt(16) );

    }


    // Методы интерфейсов по умолчанию
    // ava 8 позволяет вам добавлять неабстрактные реализации методов в интерфейс, используя ключевое слово default.
    interface Formula1 {
        double calculate1(int a);

        default double sqrt(int a) {
            return Math.sqrt(a);
        }
    }

    interface Formula2 {
        double calculate2(int a);
    }

    static class Formula implements Formula1, Formula2 {

        // переопределение
        @Override
        public double calculate1(int a){
            return a * 10; //return sqrt(a) * 100;
        }

        @Override
        public double calculate2(int a){
            return a * 100;
        }

    }
}
