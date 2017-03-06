package com.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author Aleksandr Konstantinovitch
 * @version 1.0
 * @date 19/05/2015
 * {@link http://java-study.ru/java-uchebnik/88-java-massivy}
 * {@link http://ufacode.ru/blog/7.html}
 * {@link http://habrahabr.ru/post/213805/}
 ******************************************************
 * Java массивы
 */
public class Source0 {

    public static void main(String[] args) {

        // Работа с обычными массивами в Java:
        int[] a = new int[3];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        System.out.println(a);

        int[] b = {0, 1, 2};
        System.out.println( b );

        int[] c;
        c = new int[]{0, 1, 2};
        System.out.println( c );

        System.out.println( new int[]{0, 1, 2} );


        // Работа со списками в Java:
        // (Дело в том, что в Java нельзя инициализировать коллекции, типа того, как например в php... массива — можно)
        List<String> list1 = new ArrayList<String>();
        list1.add("0");
        list1.add("1");
        list1.add("2");
        for (String item1 : list1){
            System.out.print(item1 + " ");
        }

        System.out.println();
        // (класс Arrays даёт нам в Java возможность быстрой инициализации коллекций почти так же удобно, как в каком-нибудь php)
        List<String> list2 = Arrays.asList("0", "1", "2");
        for (String item2 : list2) System.out.print(item2 + " ");


        System.out.println();
        // Лямбда-выражения в Java 8 — Простые примеры того, как они могут облегчить вашу жизнь
        List<String> numbers1 = Arrays.asList("0", "1", "2");
        numbers1.forEach((String number) -> System.out.print(number + " "));

        System.out.println();
        // можно использовать оператор :: и получить еще более красивое:
        numbers1.forEach(System.out::print);


        System.out.println();
        // Копипаст или абстракции? Выбирать вам!
        // Всё прекрасно, но количество задач растет, и в один день нам понадобился еще один метод, который находит сумму всех чисел больше 3-х...
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println( sumAll(numbers2, m -> true) );
        System.out.println( sumAll(numbers2, m -> m % 2 == 0) );
        System.out.println( sumAll(numbers2, m -> m > 3) );
    }


    public static int sumAll(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            total += number;
        }
        return total;
    }
    public static int sumAllEven(List<Integer> numbers) {
        int total = 0;
        for (int number : numbers) {
            if (number % 2 == 0) {
                total += number;
            }
        }
        return total;
    }

    // Воспользуемся еще одной фичей Java 8 — функциональным интерфейсом Predicate, который определяет, как мы будем сортировать наши числа до того, как суммировать их
    public static int sumAll(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

}
