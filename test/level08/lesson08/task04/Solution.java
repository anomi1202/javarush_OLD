package com.javarush.test.level08.lesson08.task04;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* Удалить всех людей, родившихся летом
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
Удалить из словаря всех людей, родившихся летом.
*/

public class Solution
{
    public static HashMap<String, Date> createMap()
    {
        HashMap<String, Date> map = new HashMap<String, Date>();
        for (int i = 0; i < 10; i++) {
            map.put("Stallone"+i, new Date("JUNE 2 1980"));
        }
        return map;

    }

    public static void removeAllSummerPeople(HashMap<String, Date> map)
    {
        Iterator<Map.Entry<String,Date>> itr = map.entrySet().iterator();

        while (itr.hasNext()){
            Map.Entry<String, Date> pair = itr.next();
            if(pair.getValue().getMonth()> 4 && pair.getValue().getMonth()< 8)
                itr.remove();
        }

    }
}
