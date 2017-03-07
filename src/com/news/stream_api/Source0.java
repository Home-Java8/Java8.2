package com.news.stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see https://habrahabr.ru/company/luxoft/blog/270383
 *      ***********************************************
 * Stream API это новый способ работать со структурами данных в функциональном стиле.
 * Чаще всего с помощью stream в Java 8 работают с коллекциями.
 */

public class Source0 {

    public static void main(String[] args) {
        // Создание стрима из коллекции
        Collection<String> strCollect = Arrays.asList("a1","a2","a3");
        Stream<String>  streamCollect = strCollect.stream();
        // напечатает [a1, a2, a3]
        System.out.println( streamCollect.collect(Collectors.toList()) );

        // Создание параллельного стрима из коллекции
        Stream<String>  parallelStreamCollect = strCollect.parallelStream();
        // напечатает [a1, a2, a3]
        System.out.println( parallelStreamCollect.collect(Collectors.toList()) );

        // Создание стрима из массива
        String[]          strArr = {"a4","a5","a6","a7","a8"};
        Stream<String> streamArr = Arrays.stream(strArr);
        // напечатает [a4, a5, a6, a7, a8]
        System.out.println( streamArr.collect(Collectors.toList()) );


        System.out.println("\n");


        Integer   sum;
        Integer[] arr = {1,2,3,4,5};

        sum = 0;
        for (Integer i:arr) {
            if ((i%2) == 0) //if ((i%2) != 0)
                sum += i;
        }
        System.out.println("sum="+sum);

        /**
         * с помощью Stream Api можно решить такую задачу в функциональном стиле:
         */
        sum = 0;
        sum = Arrays
                .stream(arr)
                .filter(o -> (o%2) == 0)
                .reduce((s1, s2) -> s1+s2)
                .orElse(0);
        System.out.println("sum="+sum);

        /**
         * Уже делает код параллельным, без всяких семафоров, синхронизаций, рисков взаимных блокировок:
         */
        Collection<Integer> collections = Arrays.asList(arr);
        sum = 0;
        sum = collections
                .parallelStream()
                .filter(o -> (o%2) == 0)
                .reduce((s1, s2) -> s1+s2)
                .orElse(0);
        System.out.println("sum="+sum);

        System.out.println();

        sum = collections
                .stream()
                .filter(o -> (o%2) == 0)
                .reduce(0,
                        (i, collection) -> i += collection,
                        (sum1, sum2) -> sum1+sum2);
        System.out.println("sum="+sum);
    }

}
