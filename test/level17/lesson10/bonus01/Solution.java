package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {

    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=2
    }
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static void main(String[] args) {

        if (args.length < 2 || args.length > 5)
            return;
        else {
            script(args);
        }

    }

    public static void script(String[] paramArray){
        try {
            switch (paramArray[0]) {
        /*-c name sex bd
        -c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран*/
                case "-c" :
                    cParam(paramArray);

                    break;
        /*-u id name sex bd
        -u  - обновляет данные человека с данным id*/
                case "-u" :
                    if (Integer.parseInt(paramArray[1]) < allPeople.size())
                        uParam(paramArray);
                    break;
        /*-d id
        -d  - производит логическое удаление человека с id*/
                case "-d" :
                    dParam(paramArray);
                    break;
        /*-i id
        -i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)*/
                case "-i" :
                    if (Integer.parseInt(paramArray[1]) < allPeople.size())
                        iParam(paramArray);
                    break;
            }
        }
        catch (ParseException | NumberFormatException ignored){}
    }

    //-c name sex bd
    //добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
    public static void cParam(String[] paramArray) throws ParseException {
        String name = paramArray[1];
        switch (paramArray[2]) {
            case "м":
                allPeople.add(Person.createMale(name, simpleDateFormat.parse(paramArray[3])));
                System.out.println(allPeople.size()-1);
                break;

            case "ж":
                allPeople.add(Person.createFemale(name, simpleDateFormat.parse(paramArray[3])));
                System.out.println(allPeople.size() - 1);
                break;
            default:
                break;
        }
    }

    //-u id name sex bd
    //обновляет данные человека с данным id
    public static void uParam(String[] paramArray) throws ParseException {
        int id = Integer.parseInt(paramArray[1]);

        String name=paramArray[2];
        allPeople.get(id).setName(name);

        switch(paramArray[3]){
            case "м" :
                allPeople.get(id).setSex(Sex.MALE);
                break;
            case "ж" :
                allPeople.get(id).setSex(Sex.FEMALE);
                break;
            default:
                break;
        }

        allPeople.get(id).setBirthDay(simpleDateFormat.parse(paramArray[4]));
    }

    //-d id
    //производит логическое удаление человека с id
    public static void dParam(String[] paramArray){
        int id = Integer.parseInt(paramArray[1]);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    //-i id
    //выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
    public static void iParam(String[] paramArray){
        System.out.println(allPeople.get(Integer.parseInt(paramArray[1])));
    }

}
