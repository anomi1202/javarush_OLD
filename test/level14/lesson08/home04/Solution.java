package com.javarush.test.level14.lesson08.home04;

/* Реализовать метод printMainInfo
2. Напиши реализацию метода printMainInfo, чтобы:
2.2. Если в метод передают объект типа Drawable, у этого объекта вызывался метод draw.
2.2. Если в метод передают объект типа Movable, у этого объекта вызывался метод move.
2. Метод main менять нельзя.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Object obj = new Circle();
        Movable movable = (Movable) obj;
        Drawable drawable = new Rectangle();

        printMainInfo(drawable);
        printMainInfo(movable);
    }

    public static void printMainInfo(Object object) {
        if (object instanceof Movable)
            ((Movable) object).move();
        else if (object instanceof Drawable)
            ((Drawable) object).draw();
    }

    static interface Movable
    {

        void move();
    }

    static class Circle implements Movable
    {

        public void draw()
        {
            System.out.println("can be drawn");
        }

        public void move()
        {
            System.out.println("can be moved");
        }

    }

    static interface Drawable
    {
        void draw();
    }

    static class Rectangle implements Drawable
    {
        public void draw()
        {
            System.out.println("can be drawn");
        }

        public void move()
        {
            System.out.println("can be moved");
        }
    }
}
