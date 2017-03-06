package com.lambda0;

/**
 * Created by Саша on 23.05.2015.
 */
public class My1 {

    public static void main(String[] args) {
        System.out.println(Shape.str1);
//        System.out.println(Shape.str2);
        System.out.println(Drawer.b); // System.out.println(Shape.a); // (так нельзя)
    }
}


abstract class Shape {
    protected Drawer drawer;
    public static String str1 = "str1";
    private static String str2 = "str2";

    protected Shape(Drawer drawer){
        this.drawer = drawer;
    }

    protected abstract void draw();
    public abstract void enlargeRadius(int multiplier);
//    private abstract void tmp();
}

interface Drawer {
    public int a = 100;
    public static int b = 200;
    public void drawCircle(int x, int y, int radius);
}
