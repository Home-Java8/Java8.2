package com.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by alexandr on 19.05.15.
 * {@link http://habrahabr.ru/post/216431/}
 * ***************************************************************************************************
 * Новое в Java 8
 * Лямбда-выражение является блоком кода с параметрами.
 * Используются лямбда-выражение, когда необходимо выполнить блок кода в более поздний момент времени.
 */
public class Source1 {

    public static void main(String[] args) {
        List<String> names1 = Arrays.asList("peter1", "anna1", "mike1", "xenia1");
        System.out.println(names1);

        List<String> names2 = Arrays.asList("peter2", "anna2", "mike2", "xenia2");
        Collections.sort(names2, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println(names2);

        List<String> names3 = Arrays.asList("peter3", "anna3", "mike3", "xenia3");
        Collections.sort(names3, (String a, String b) -> {
            return b.compareTo(a);
        });
        System.out.println(names3);

        List<String> names4 = Arrays.asList("peter3", "anna3", "mike3", "xenia3");
        Collections.sort(names4, (a, b) -> b.compareTo(a));
        System.out.println(names4);


        // Каждой лямбде соответствует тип, представленный интерфейсом. Так называемый функциональный интерфейс должен содержать ровно один абстрактный метод.
        Converter<String, Integer> converter1 = (fron) -> Integer.valueOf(fron);
        Converter<String, Integer> converter2 = Integer::valueOf;
        Converter<byte[], String> converter3 = String::new;
//        System.out.println( converter("sdfdsfs") );


        final int num = 1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from + num);
        System.out.println( stringConverter.convert(3) );

        // Встроенные функциональные интерфейсы
        Predicate<String> predicate = (s) -> s.length() > 0;
        names4.forEach((String name4) -> predicate.test(name4));
//                .((p) -> System.out.println(p.getName()));
//        System.out.println( names4.forEach((String name4) -> predicate.test(name4)) );

//        Function<String, Integer> toInteger = Integer::valueOf;
//        Function<String, String> backToString = toInteger.andThen(String::valueOf);
//        Supplier<Person> personSupplier = Person::new;
//        Person person = personSupplier.get();
//        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
//        Comparator<Person> comparator = (p1, p2) -> p1.firstName.compareTo(p2.firstName);

//        Supplier<People> personSupplier = People::new;
//        People people = personSupplier.get();
//        Comparator<People> comparator = (p1, p2) -> p1.getName().compareTo(p2.getName());
//        Comparator<String> myComparator = (p1, p2) -> p1.toString().compareTo(p2.toString());
//        myComparator.compa


        Converter<String, Integer>myConverter = (from) -> Integer.valueOf(from);
        Integer converted = myConverter.convert("123");
        System.out.print(converted);
    }


    // Каждой лямбде соответствует тип, представленный интерфейсом. Так называемый функциональный интерфейс должен содержать ровно один абстрактный метод.
    // Каждое лямбда-выражение этого типа будет сопоставлено объявленному методу.
    @FunctionalInterface
    interface Converter<A, B>{
        B convert(A fron);
    }


    // Является ли описанный интерфейс функциональным
    public interface Function<T, R> {
        R doSomething(T t);
        default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
            return (T t) -> after.doSomething(doSomething(t));
        }
    }


    public static class People {
        private String name;
        private int age;

        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setAge(int age){
            this.age = age;
        }
    }

}
