package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
2. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        Man man0 = new Man("123na",13,"ad12313w");
        Man man1 = new Man("n1231312a",13,"ad1412w");
        Woman woman0 = new Woman("n7987a",113,"a124131dw");
        Woman woman1 = new Woman("142na",1143,"a123123dw");

        System.out.println(man0.name + " " + man0.age + " " + man0.address);
        System.out.println(man1.name + " " + man1.age + " " + man1.address);
        System.out.println(woman0.name + " " + woman0.age + " " + woman0.address);
        System.out.println(woman1.name + " " + woman1.age + " " + woman1.address);
    }

    public static class Man{
        String name;
        int age;
        String address;
        public Man(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }

    public static class Woman{
        String name;
        int age;
        String address;
        public Woman(String name, int age, String address){
            this.name = name;
            this.age = age;
            this.address = address;
        }
    }
}
