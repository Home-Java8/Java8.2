package com.news.default_methods.source2;

public class Source {

    public static void main(String[] args) {
        new Test().print(); // class-Test
    }

}


interface A {
    default void print(){
        System.out.println("interface-A");
    }
}

interface B {
    default void print(){
        System.out.println("interface-B");
    }
}

class Test implements A, B {
    @Override
    public void print(){ // если непереопределить - тогда будет ошибка компиляции...
        System.out.println("class-Test");
    }
}