package com.news.stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

/**
 * @see https://m.habrahabr.ru/post/302628
 *      **********************************
 * Stream API используется для работы с коллекциями, позволяя писать код в функциональном стиле.
 * Немного познакомились с простыми операциями, поняли отличие между конвейерными и терминальными операциями, попробовали и те и другие.
 */
public class Source1 {

    public static void main(String[] args) {
        /**
         * Пример № 1
         * Нахождение максимального и минимального значений
         */
        Optional<Integer> maxValue,minValue;
        ArrayList<Integer> testValues = new ArrayList();
        testValues.add(0,15);
        testValues.add(1,1);
        testValues.add(2,2);
        testValues.add(3,100);
        testValues.add(4,50);

        maxValue = testValues
                .stream()
                .max(Integer::compareTo);
        minValue = testValues
                .stream()
                .min(Integer::compareTo);

        System.out.println("MaxValue="+maxValue);
        System.out.println("MinValue="+minValue);

        System.out.println();

        /**
         * Пример № 2
         * Нахождение максимального значения исключая null значения
         */
        Optional<Integer> maxValueNotNull;
        ArrayList<Integer> testValuesNull = new ArrayList();
        testValuesNull.add(0,null);
        testValuesNull.add(1,1);
        testValuesNull.add(2,2);
        testValuesNull.add(3,70);
        testValuesNull.add(4,50);

        maxValueNotNull =  testValuesNull
                .stream()
                .filter((p) -> p != null) //.filter(p -> p != null)
                .max(Integer::compareTo);

        System.out.println("maxValueNotNull="+maxValueNotNull);

        System.out.println();

        /**
         * Пример 3
         * Поиск имени самого большого по продолжительности нахождения в лагере
         */
        Collection<SportsCamp> sports;
        String name;

        sports = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );

        name = sports
                .stream()
                .max((sport1, sport2) -> sport1.getDay().compareTo(sport2.getDay()))
                .get()
                .getName();

        System.out.println("Name="+name);

        /**
         * Пример № 4
         * В этом случае вы получите результат, равный "Name=null".
         */
        sports = Arrays.asList(
                new SportsCamp("Ivan", 5),
                new SportsCamp( null, 15),
                new SportsCamp("Petr", 7),
                new SportsCamp("Ira", 10)
        );

        name = sports
                .stream()
                .filter((sport) -> sport.getName() != null)
                .max((sport1, sport2) -> sport1.getDay().compareTo(sport2.getDay()))
                .get()
                .getName();

        System.out.println("Name="+name);

        /**
         * Пример № 5
         * Добавим сортировку и вывод определенного элемента, например, добавим фильтр по именам с встречающимся «Ivan» и произведем подсчет таких элементов (исключим null значения).
         */
        long count;

        count = sports
                .stream()
                .filter((sport) -> sport.getName() != null && sport.getName().equals("Ivan"))
                .count();

        System.out.println("count="+count);

        /**
         * Пример № 6
         * Есть возможность использовать обработку через parallelStream().
         */
        count = sports
                .parallelStream()
                .filter((sport) -> sport.getName() != null && sport.getName().equals("Ivan"))
                .count();

        System.out.println("count="+count);
    }

}


/*
 * коллекция "спортивный лагерь"
 */
class SportsCamp {
    private String name; // Имя спортсмена
    private Integer day; // Количество дней в спортивном лагере

    public SportsCamp(String name, int day) {
        this.name = name;
        this.day = day;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }
}