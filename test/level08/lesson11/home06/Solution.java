package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
2. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)
    {
        ArrayList<Human> children0 = new ArrayList<>();
        Human so1 = new Human("so1",true,5,new ArrayList<Human>());
        Human so2 = new Human("so1",true,9,new ArrayList<Human>());
        Human da = new Human("da",false,3,new ArrayList<Human>());
        children0.add(so1);
        children0.add(so2);
        children0.add(da);

        ArrayList<Human> children1 = new ArrayList<>();
        Human father = new Human("father",true,5,children0);
        children1.add(father);

        ArrayList<Human> children2 = new ArrayList<>();
        Human mother = new Human("mother",true,5,children0);
        children2.add(mother);

        Human grf1 = new Human("grf1",true,65,children1);
        Human grm1 = new Human("grm1",false,65,children1);

        Human grf2 = new Human("grf2",true,65,children2);
        Human grm2 = new Human("grm2",false,65,children2);

        System.out.println(grf1.toString());
        System.out.println(grm1.toString());
        System.out.println(grf2.toString());
        System.out.println(grm2.toString());

        System.out.println(father.toString());
        System.out.println(mother.toString());

        System.out.println(so1.toString());
        System.out.println(so2.toString());
        System.out.println(da.toString());

    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<>();

        public Human(String name, boolean sex, int age, ArrayList<Human> child){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = child;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
