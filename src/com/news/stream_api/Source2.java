package com.news.stream_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @see https://m.habrahabr.ru/post/302628
 *      **********************************
 * Посмотрим примеры более сложных операций, например, collect и Map, Flat и Reduce.
 */

public class Source2 {

    public static void main(String[] args) {
        Collection<SportsCamp> sports;
        List<SportsCamp>       onlyI;
        String                 name;
        Integer                days;

        /**
         * Пример № 1
         * В новом примере попробуем преобразовать одну коллекцию в другую, по именам начинающимся с "I" и запишем это в List.
         */
        sports = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp(null, 15),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );

        onlyI = sports
                .stream()
                .filter(sport -> sport.getName() != null && sport.getName().startsWith("I")) //.filter((sport) -> sport.getName() != null &&  sport.getName().startsWith("I"))
                .collect(Collectors.toList());

        System.out.println("SIZE = "+onlyI.size());

        /**
         * Пример № 2
         * (Collectors обладает массой возможностей, включая вывод среднего значения или информации со статистикой) попробуем соединить данные.
         */
        name =  sports
                .stream()
                .filter(sport -> sport.getName() != null)
                .map(SportsCamp::getName)
                .collect(Collectors.joining(" and ", "In camp ", " rest all days."));

        System.out.println(name);

        /**
         * Пример № 3
         * Reduce используется для сборки элементов (если вы хотите в потоке произвести создание нового экземпляра объекта с агрегирующими показателями других элементов)
         * произведем суммирование данных по всем дням пребывания в спортивном лагере.
         */
        days = sports
                .stream()
                .reduce(0,                                 // "reduce" принимает 3-значения: 1-ый – иннициализируем;
                        (i, sport) -> i += sport.getDay(), //   2-ой – аккумулятор (прибавляем к старому значению следующее значение);
                        (sum1, sum2) -> sum1 + sum2);      //   3-ий – фактически объедение (фиксируем результат значений обоих объектов);
        /*
         * (Существуют и несколько других вариантов использования "reduce")
         * То же самое можно было бы сделать и через for (int i=0; i<..length; i++) ...
         */

        System.out.println("Days = " + days);
    }

}
