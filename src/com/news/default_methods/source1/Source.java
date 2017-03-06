package com.news.default_methods.source1;

public class Source {

    public static void main(String[] args) {
        new Test().print(); // interface-A
    }

}


interface A {
    default void print(){
        System.out.println("interface-A");
    }
}

class Test implements A {}
