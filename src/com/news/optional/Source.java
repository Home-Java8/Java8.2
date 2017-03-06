package com.news.optional;

import java.util.Optional;

/**
 * @
 */

public class Source {

    public static void main(String[] args) {
        Optional<String> name1;

        name1 = Optional.ofNullable(null);
        System.out.println("Is name = " + name1.isPresent());
        System.out.println("Name is: " + name1.orElseGet(() -> "[none]"));
        System.out.println(name1.map(s -> s+"!").orElse("~?"));

        System.out.println();

        name1 = Optional.of("Tom");
        System.out.println("Is name = " + name1.isPresent());
        System.out.println("Name is: " + name1.orElseGet(() -> "[none]"));
        System.out.println(name1.map( s -> s+"!" ).orElse( "~?" ) );
    }

}
