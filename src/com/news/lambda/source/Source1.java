package com.news.lambda.source;

import java.util.function.BiFunction;

/**
 * @see https://habrahabr.ru/post/224593/
 * @see http://www.concretepage.com/java/jdk-8/java-8-biconsumer-bifunction-bipredicate-example
 */

public class Source1 {

    public static void main(String[] args) {
        Face1 f1 = () -> System.out.println("Hello!");
        f1.get();

        Face2 f2 = (String arg) -> System.out.println(arg);
        f2.get("Hello!");

        Face3 f3 = (Integer arg1, Integer arg2) -> {
            if (arg1<arg2) System.out.println(1);
            else if (arg1>arg2) System.out.println(-1);
            else if (arg1==arg2) System.out.println(0);
        };
        f3.get(10,1);

        BiFunction<Integer, Integer, Boolean> compare = (arg1,arg2) -> {
            if (arg1<arg2) return true;
            return false;
        };
        if (compare.apply(10,1))
            System.out.println( "YES" );
        else
            System.out.println( "ERR" );

        BiFunction<Integer[], Integer[], Integer[]> combine = (args1,args2) -> {
            Integer[] all = new Integer[args1.length + args2.length];
            System.arraycopy(args1,0,all,0,args1.length);
            System.arraycopy(args2,0,all,args1.length,args2.length);
            return all;
        };
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {4,5,6,7,8,9};
        Integer[] arr3 = combine.apply(arr1, arr2);
        for (Integer a:arr3) System.out.print(a);



        System.out.println("\n");

//        Face10 f10 = (Integer[] arr) -> {
//            for (Integer x:arr) System.out.print(x);
//        };
//        f10.get(arr3);
        Face10 f10 = x -> System.out.print(x);
        f10.print("Hello!");

        System.out.println();

        Face10 f11 = System.out::print;
        f11.print("Hello!!");

        System.out.println();

        Face10 f12 = Clas10::print;
        f12.print("Hello!!!");

        System.out.println();

        Face11 f13 = Clas11::prints;
        f13.prints(arr3);

        System.out.println();

        Face12 f14 = Clas12::equal;
        System.out.println( f14.equal(10,10) );

        System.out.println();
    }
}


interface Face1 {
    void get();
}

interface Face2 {
    void get(String arg);
}

interface Face3 {
    void get(Integer arg1, Integer arg2);
}


interface Face10 {
    void print(String arg);
}

class Clas10 {
    public static void print(String arg) {
        System.out.print(arg);
    }
}


interface Face11 {
    void prints(Integer[] arr);
}

class Clas11 {
    public static void prints(Integer[] args) {
        for (Integer arg : args) System.out.print(arg);
    }
}


interface Face12 {
    boolean equal(Integer arg1, Integer arg2);
}

class Clas12 {
    public static boolean equal(Integer arg1, Integer arg2){
        if (arg1 == arg2)
            return true;
        return false;
    }
}