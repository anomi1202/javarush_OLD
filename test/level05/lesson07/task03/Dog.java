package com.javarush.test.level05.lesson07.task03;

/* Создать класс Dog
Создать класс Dog (собака) с тремя инициализаторами:
- Имя
- Имя, рост
- Имя, рост, цвет
*/

public class Dog
{
    private String name=null;
    private int size=10;
    private String color = null;

    public void initialize(String name){
        this.name=name;
    }
    public void initialize(String name,int size){
        this.name = name;
        this.size = size;
    }
    public void initialize(String name,int size, String color)
    {
        this.name = name;
        this.size = size;
        this.color = color;
    }
}
