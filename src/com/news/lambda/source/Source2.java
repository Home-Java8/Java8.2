package com.news.lambda.source;

import java.util.Arrays;
import java.util.List;

/**
 * @see https://habrahabr.ru/post/224593/
 */
public class Source2 {

    public static void main(String[] args) {
//        Синтаксис лямбда-выражений

        /*
         * форма лямбда-выражений в Java:
         *      () -> выражение
         *
         * Вычисление которое не вписывается в одно выражение записывается как метод заключенный в {} и с явными выражениями return.
         * Если лямбда-выражение не имеет параметров то ставят пустые скобки.
         *      (параметры) -> {
         *          выражение;
         *          return 0;
         *       }
         *
         */

        /*
         * (Лучше всего думать о лямбда-выражении как о функции, а не об объекте)
         * (В Java нельзя даже присвоить лямбда-выражение переменной типа Object, потому Object не является функциональным интерфейсом)
         *  **************************************************************************************************************************
         * (Integer first, String second) -> {
         *     if (first<second) return -1;
         *     else if (first>second) return 1;
         *     else return 0;
         * }
         */

        /*
         * Если типы параметров лямбда-выражения можно вывести, то можно опустить их:
         * *************************************************************************
         * (first, second) -> {
         *     if (first<second) return -1;
         *     else if (first>second) return 1;
         *     else return 0;
         * }
         */

        /*
         * лямбда-выражение может не имеет параметров:
         * ******************************************
         * () -> { for (int i=0; i<10; i++) System.out.print(i); }
         */

        /*
         * преобразование в функциональный интерфейс - это единственное что вы можете сделать с лямбда-выражением в Java:
         * **************************************************************************************************************
         * Comparator<Integer> comparator = (first, second) -> Integer.compare(first,second);
         * names.sort(comparator);
         */


        Integer[] arr = {4,7,1,5,6,3,2};
        List<Integer> names = Arrays.asList(arr);

        for (Integer name:names) System.out.print(name);
        System.out.println();
        names.forEach( (Integer arg) -> System.out.print(arg) );
        System.out.println();
        names.forEach( name -> System.out.print(name) );
        System.out.println();
        names.forEach( System.out::print );

        System.out.println("\n");

        Arrays.sort(arr, (first, second) -> Integer.compare(second,first));
        for (Integer a:arr) System.out.print(a);
        System.out.println();
        names.sort((first, second) -> Integer.compare(first,second));
//        Comparator<Integer> comp1 = (first,second) -> Integer.compare(first, second);
//        names.sort(comp1);
        names.forEach(System.out::print);



//        Функциональные интерфейсы - должен иметь единственный абстрактный метод.
        System.out.println("\n");

        Runnable run = () -> System.out.print("run");
        new Thread(run).start();



//        Java API определяет несколько универсальных функциональных интерфейсов в пакете java.util.function.
//        Один из интерфейсов, BiFunction <T, U, R>, описывает функции с типами Т и U и типом возвращаемого значения R.


        /*
         *  Ссылки на методы + Ссылки на конструктор:
         * Иногда уже есть метод, который осуществляет именно те действия, которые вы хотели бы передать в другое место.
         * оператор :: отделяет имя метода от имени объекта или класса. Есть три основных варианта:
         * 1. object::instanceMethod
         * 2. Class::staticMethod
         * 3. Class::instanceMethod
         */

        System.out.println("\n");
        for (Integer x:arr) System.out.print(x);
        System.out.print(" ... ");
        names.forEach( System.out::print );
        System.out.println();
        System.out.println("\n");

    }

}
