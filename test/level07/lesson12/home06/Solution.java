package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //sex true = max
        //sex false = women
        Human grF1 = new Human("grF1", true, 65, null, null);
        Human grF2 = new Human("grF2", true, 75, null, null);
        Human grM1 = new Human("grM1", false, 65, null, null);
        Human grM2 = new Human("grM2", false, 75, null, null);
        Human fa = new Human("fa", true, 30, grF1, grM1);
        Human mo = new Human("mo", false, 25, grF2, grM2);
        Human so = new Human("so", true, 9, fa, mo);
        Human da1 = new Human("da1", false, 7, fa, mo);
        Human da2 = new Human("da2", false, 5, fa, mo);

        System.out.println(grF1.toString());
        System.out.println(grF2.toString());
        System.out.println(grM1.toString());
        System.out.println(grM2.toString());
        System.out.println(fa.toString());
        System.out.println(mo.toString());
        System.out.println(so.toString());
        System.out.println(da1.toString());
        System.out.println(da2.toString());
    }

    public static class Human    {
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age, Human father, Human mother){
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString(){
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
