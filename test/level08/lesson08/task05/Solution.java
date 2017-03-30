package com.javarush.test.level08.lesson08.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution {
    public static void main(String[] args) {

        removeTheFirstNameDuplicates(createMap());
    }

    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Tom", "Tom");
        map.put("Arbus", "Tom");
        map.put("Arbu1s", "Arbus");
        map.put("Baby", "Baby");
        map.put("Cat", "Cat");
        map.put("Dog", "Dog");
        map.put("Eat", "Eat");
        map.put("Food", "Food");
        map.put("Gevey", "Gevey");
        map.put("Hugs", "Hugs");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {

        ArrayList<String> listNameDublicates = new ArrayList<>();
        for (Map.Entry<String, String> pair : map.entrySet()) {
            int count = 0;
            for (Map.Entry<String, String> pair1 : map.entrySet()) {
                if (pair.getValue().equals(pair1.getValue()))
                    count+=1;
            }
            if(count>1){
                listNameDublicates.add(pair.getValue());
            }
        }
        for (int i = 0; i < listNameDublicates.size(); i++) {
            removeItemFromMapByValue(map, listNameDublicates.get(i));
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair: copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
