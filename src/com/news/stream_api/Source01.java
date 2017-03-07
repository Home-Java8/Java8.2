package com.news.stream_api;

import java.util.OptionalInt;
import java.util.stream.IntStream;

/**
 * @see http://javadevblog.com/polnoe-rukovodstvo-po-java-8-stream.html
 */
public class Source01 {

    public static void main(String[] args) {
        for (int i=0; i<10; i++) {
            System.out.print( i );
        }

        System.out.println();

        IntStream.range(0,10)
                .forEach(System.out::print);


        System.out.println();


        OptionalInt min = IntStream.range(8,12)
                .min();
        System.out.println(min);

        IntStream.range(8,12)
                .min()
                .ifPresent(System.out::println);

        IntStream.range(8,12)
                .max()
                .ifPresent(System.out::println);

        IntStream.range(8,12)
                .average()
                .ifPresent(System.out::println);

        Integer sum = IntStream.range(8, 12)
                        .sum();
        System.out.println("sum="+sum);

    }

}
