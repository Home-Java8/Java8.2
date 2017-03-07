package com.news.stream_api;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @see http://javadevblog.com/polnoe-rukovodstvo-po-java-8-stream.html
 */
public class Source02 {

    public static void main(String[] args) {
        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("Фильтр: " + s);
                    return true;
                });

        Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
                .filter(s -> {
                    System.out.println("Фильтр: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("Печать с использованием forEach: " + s));



        Collection<String> collection = Arrays.asList("dd2", "aa2", "bb1", "bb3", "cc4");

        collection.stream()
//                .map(String::toUpperCase)
                .peek((e) -> System.out.print("," + e)).
                collect(Collectors.toList());
    }

}
