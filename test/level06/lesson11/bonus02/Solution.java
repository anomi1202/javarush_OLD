package com.javarush.test.level06.lesson11.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: У каждой кошки есть имя и кошка-мама. Создать класс, который бы описывал данную ситуацию. Создать два объекта: кошку-дочь и кошку-маму. Вывести их на экран.
Новая задача: У каждой кошки есть имя, кошка-папа и кошка-мама. Изменить класс Cat так, чтобы он мог описать данную ситуацию.
Создать 6 объектов: дедушку(папин папа), бабушку(мамина мама), папу, маму, сына, дочь.
Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.

Пример ввода:
дедушка Вася
бабушка Мурка
папа Котофей
мама Василиса
сын Мурчик
дочь Пушинка

Пример вывода:
Cat name is дедушка Вася, no mother, no father
Cat name is бабушка Мурка, no mother, no father
Cat name is папа Котофей, no mother, father is дедушка Вася
Cat name is мама Василиса, mother is бабушка Мурка, no father
Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String grFa = reader.readLine();
        String grMo = reader.readLine();
        String Fa = reader.readLine();
        String Mo = reader.readLine();
        String So = reader.readLine();
        String Da = reader.readLine();

        Cat grM = new Cat(grMo);
        Cat grF = new Cat(grFa);
        Cat dad = new Cat(Fa,grF,null);
        Cat mam = new Cat(Mo,null,grM);
        Cat s = new Cat(So,dad,mam);
        Cat d = new Cat(Da,dad,mam);

        System.out.println(grF);
        System.out.println(grM);
        System.out.println(dad);
        System.out.println(mam);
        System.out.println(s);
        System.out.println(d);


    }

    public static class Cat
    {
        private String name;
        private Cat mam;
        private Cat dad;

        Cat(String name)
        {
            this.name = name;
        }

        Cat(String name,Cat dad, Cat mam)
        {
            this.name = name;
            this.mam = mam;
            this.dad = dad;
        }

        @Override
        public String toString()
        {
            if (mam == null && dad==null)
                return "Cat name is " + name + ", no mother, no father";
                else if (mam == null)
                    return "Cat name is " + name + ", no mother, " + "father is " + dad.name;
                    else if (dad == null)
                        return "Cat name is " + name + ", mother is " + mam.name + ", no father";
            else
                return "Cat name is " + name + ", mother is " + mam.name + ", father is " + dad.name;
        }
    }

}
