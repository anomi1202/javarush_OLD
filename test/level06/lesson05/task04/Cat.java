package com.javarush.test.level06.lesson05.task04;

/* Cчётчик котов
В конструкторе класса Cat [public Cat()] увеличивать счётчик котов (статическую переменную этого же класса catCount) на 2. В методе finalize уменьшать на 2.
*/

public class Cat
{
    public static int catCount = 0;

    public Cat(){
        catCount+=1;
    }
    protected void finalize() throws Throwable{
        catCount-=1;
    }

    public static void main(String[] args) {
    }
}
