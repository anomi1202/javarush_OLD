package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String name;
        int age;
        int weight;
        String addres;
        boolean sex;
        ArrayList<Human> child = new ArrayList<>();

        public Human(String name){
            this.name = name;
        }
        public Human(String name, int age){
            this.name = name;
            this.age = age;
        }
        public Human(String name, int age, int weight){
            this.name = name;
            this.age = age;
            this.weight = weight;
        }
        public Human(String name, int age, int weight, String addres){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.addres = addres;
        }
        public Human(String name, int age, int weight, String addres, boolean sex){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.addres = addres;
            this.sex = sex;
        }
        public Human(String name, int age, int weight, String addres, boolean sex, Human child){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.addres = addres;
            this.sex = sex;
            this.child.add(child);
        }
        public Human(String name, int age, int weight, String addres, boolean sex, Human child1, Human child2){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.addres = addres;
            this.sex = sex;
            this.child.add(child1);
            this.child.add(child2);
        }
        public Human(String name, int age, int weight, String addres, boolean sex, Human child1, Human child2, Human child3){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.addres = addres;
            this.sex = sex;
            this.child.add(child1);
            this.child.add(child2);
            this.child.add(child3);
        }
        public Human(String name, int age, int weight, String addres, boolean sex, Human child1, Human child2, Human child3, Human child4){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.addres = addres;
            this.sex = sex;
            this.child.add(child1);
            this.child.add(child2);
            this.child.add(child3);
            this.child.add(child4);

        }
        public Human(String name, int age, int weight, String addres, boolean sex, Human child1, Human child2, Human child3, Human child4, Human child5){
            this.name = name;
            this.age = age;
            this.weight = weight;
            this.addres = addres;
            this.sex = sex;
            this.child.add(child1);
            this.child.add(child2);
            this.child.add(child3);
            this.child.add(child4);
            this.child.add(child5);

        }

    }
}
