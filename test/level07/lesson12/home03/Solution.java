package com.javarush.test.level07.lesson12.home03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Максимальное и минимальное числа в массиве
Создать массив на 20 чисел. Заполнить его числами с клавиатуры. Найти максимальное и минимальное числа в массиве.
Вывести на экран максимальное и минимальное числа через пробел.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            arrayList.add(Integer.parseInt(reader.readLine()));
        }

        int  maximum = arrayList.get(0);
        int  minimum = arrayList.get(0);

        for (int i = 0; i < arrayList.size(); i++) {
            maximum = arrayList.get(i) > maximum ? arrayList.get(i) : maximum;
            minimum = arrayList.get(i) < minimum ? arrayList.get(i) : minimum;
        }


        System.out.print(maximum + " " + minimum);
    }
}
