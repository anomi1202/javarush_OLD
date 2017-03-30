package com.javarush.test.level08.lesson08.task03;

import java.util.HashMap;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{
    public static HashMap<String, String> createMap() {

        HashMap<String,String> map = new HashMap<>();
        String firstName;
        String lastName;
        for (int i = 0; i < 10; i++) {
            firstName ="i" + i;
            lastName = "i" + i;
            map.put(lastName,firstName);
        }

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count =0;

        for (Map.Entry<String, String> pair: map.entrySet()) {
            count += pair.getValue().equals(name) ? 1:0;
        }

        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        int count =0;

        for (Map.Entry<String, String> pair: map.entrySet()) {
            count += pair.getKey().equals(lastName) ? 1:0;
        }

        return count;

    }
}
