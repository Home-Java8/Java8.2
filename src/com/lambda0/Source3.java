package com.lambda0;

/**
 * Created by alexandr on 19.05.15.
 */
public class Source3 {

    public static void main(String[] args) {
        C c = new C();
        c.print();
    }



    public interface A {
        int a();

        default void print(){
            System.out.println("interface A");
        }
    }

    public interface B {
        int b();

        default void print(){
            System.out.println("interface B");
        }
    }

    public static class C implements A, B {
        @Override
        public int a(){
            print();
            return 0;
        }

        @Override
        public int b(){
            print();
            return -1;
        }

        @Override
        public void print(){
            System.out.println("class C");
        }
    }

}
