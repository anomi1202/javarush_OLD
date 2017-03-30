package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=2
    }
    public static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    public static void main(String[] args) {
        if (args.length < 2)
            return;
        else
            script(args);

    }
        public static void script(String[] args){
            try {
                switch (args[0]) {
        /*-c name1 sex1 bd1 name2 sex2 bd2 ...
        -с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке*/
                    case "-c" :
                        for (int i = 1; i < args.length; i += 3) {
                            cParam(new String[]{args[i], args[i + 1], args[i + 2]});
                        }
                        break;
        /*-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
        -u  - обновляет соответствующие данные людей с заданными id*/
                    case "-u" :
                        for (int i = 1; i < args.length; i+=4) {
                            if (Integer.parseInt(args[i]) < allPeople.size())
                                uParam(new String[]{args[i],args[i+1], args[i+2], args[i+3]});
                        }
                        break;
        /*-d id1 id2 id3 id4 ...
        -d  - производит логическое удаление всех людей с заданными id*/
                    case "-d" :
                        for (int i = 1; i < args.length; i++) {
                            dParam(args[i]);
                        }

                        break;
        /*-i id1 id2 id3 id4 ...
        -i  - выводит на экран информацию о всех людях с заданными id: name sex bd*/
                    case "-i" :
                        for (int i = 1; i < args.length; i++) {
                            if (Integer.parseInt(args[i]) < allPeople.size())
                                iParam(args[i]);
                        }
                        break;
                }
            }
            catch (ParseException | NumberFormatException ignored){}
        }

        //-c name sex bd
        //добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
    public synchronized static void cParam(String[] paramArray) throws ParseException {
        int i = 0;
        String name = paramArray[i];
        switch (paramArray[i+1]) {
            case "м":
                allPeople.add(Person.createMale(name, simpleDateFormat.parse(paramArray[i+2])));
                System.out.println(allPeople.size()-1);
                break;

            case "ж":
                allPeople.add(Person.createFemale(name, simpleDateFormat.parse(paramArray[i+2])));
                System.out.println(allPeople.size() - 1);
                break;
            default:
                break;
        }
    }

    //-u id name sex bd
    //обновляет данные человека с данным id
    public synchronized static void uParam(String[] paramArray) throws ParseException {
        int i = 0;
        int id = Integer.parseInt(paramArray[i]);

        String name=paramArray[i+1];
        allPeople.get(id).setName(name);

        switch(paramArray[i+2]){
            case "м" :
                allPeople.get(id).setSex(Sex.MALE);
                break;
            case "ж" :
                allPeople.get(id).setSex(Sex.FEMALE);
                break;
            default:
                break;
        }

        allPeople.get(id).setBirthDay(simpleDateFormat.parse(paramArray[i+3]));
    }

    //-d id
    //производит логическое удаление человека с id
    public synchronized static void dParam(String paramArray){
        int id = Integer.parseInt(paramArray);
        allPeople.get(id).setName(null);
        allPeople.get(id).setSex(null);
        allPeople.get(id).setBirthDay(null);
    }

    //-i id
    //выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
    public synchronized static void iParam(String paramArray){
        System.out.println(allPeople.get(Integer.parseInt(paramArray)));
    }
}
