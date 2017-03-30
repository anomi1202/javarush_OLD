package com.javarush.test.level05.lesson09.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя конструкторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name=null;
    private int size=10;
    private String color = null;

    public Dog(String name){
        this.name=name;
    }
    public Dog(String name,int size){
        this.name = name;
        this.size = size;
    }
    public Dog(String name,int size, String color)
    {
        this.name = name;
        this.size = size;
        this.color = color;
    }

}
