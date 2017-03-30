package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
2. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            list.add(reader.readLine());
        }

        int minLenght=list.get(0).toCharArray().length;
        for (int i = 0; i < list.size(); i++) {
            minLenght = list.get(i).toCharArray().length < minLenght ? list.get(i).toCharArray().length : minLenght;
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).toCharArray().length == minLenght)
                System.out.println(list.get(i));
        }

    }
}
