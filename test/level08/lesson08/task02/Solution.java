package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        HashSet<Integer> setInt = new HashSet<>();
        for (int i = 0; i < 20; i++) {
            setInt.add(i*5);
        }
        return setInt;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        int curr;
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()){
            curr = itr.next();
            if (curr > 10)
                itr.remove();
        }
        return set;
    }
}
