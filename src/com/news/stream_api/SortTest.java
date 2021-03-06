package com.news.stream_api;


/**
 * @see http://javapitstop.com/article/fighting-with-nullpointerexception-6/
 *      http://microfork.com/whats-new-in-java-8/
 *      https://habrahabr.ru/post/225641/
 *
 * http://javahero.ru/java-8-пример-фильтрации-с-помощью-потоков/
 * https://dou.ua/lenta/articles/oracle-certified-java-8/
 *
 *
 * Проблелмы которые могут быть при работе с цыклами:
 * *************************************************
 * 1. Безопасное использование, в случае ошибки есть вероятность зацыкливания
 * 2. Неоптимальное использование: лишние прохождения в цыкле там где этого НЕнужно
 * 3. Если присутствует конкретное условие (получить только первый / последний элемент из массива)
 *
 * Проблелмы которые могут быть при работе с условными въетвлениями:
 * ****************************************************************
 * 1. Отсутствует проверка на NULL
 * 2. Отсутствует проверка на 0 (минимум / максимум для размера массива)
 * 3. Порядок проверки условных значений
 * 4. Порядок проверки условных значений внутри массива (в случае NULL / 0)
 */

public class SortTest {

    public static void main(String[] args) {
        int[] arr1 = {8,9,0,1,2,5,6,7,3,4};
        int[] arr2 = {8,9,0,1,2,5,6,7,3,4};

        /**
         * Сортировка проходит стабильно-полное количество цыклов!
         */
        for (int a1=0; a1<arr1.length; ++a1){
            for (int a2=0; a2<arr1.length; ++a2){
                if(arr1[a1]<arr1[a2]){
                    int t = arr1[a1];
                    arr1[a1] = arr1[a2];
                    arr1[a2] = t;
                }
                System.out.print("*");
            }
        }
        for (int a1:arr1) System.out.print(a1);

        System.out.println();

        /**
         * Оптимизированная сортировка проходит меньшее количество цыклов (только при необходимости)!
         */
        for (int a1=0; a1<arr2.length; ++a1){
            for (int a2=arr2.length-1; 0<a2; --a2){
                if(arr2[a1]<arr2[a2]){
                    int t = arr2[a1];
                    arr2[a1] = arr2[a2];
                    arr2[a2] = t;
                }
                System.out.print("*");
            }
        }
        for (int a2:arr2) System.out.print(a2);
    }

}
