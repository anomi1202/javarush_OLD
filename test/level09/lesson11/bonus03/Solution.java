package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
2
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
2
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> arrayListInteger = new ArrayList<>();
        ArrayList<String> arrayListString = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i]))
                arrayListInteger.add(Integer.parseInt(array[i]));
            else arrayListString.add(array[i]);
        }

        for (int i = 0; i < arrayListInteger.size(); i++) {
            int temp;
            for (int j = i+1; j < arrayListInteger.size(); j++) {
                if (arrayListInteger.get(j)>arrayListInteger.get(i)) {
                    temp = arrayListInteger.get(i);
                    arrayListInteger.set(i,arrayListInteger.get(j));
                    arrayListInteger.set(j,temp);
                }
            }
        }

        for (int i = 0; i < arrayListString.size(); i++) {
            String temp;
            for (int j = i+1; j < arrayListString.size(); j++) {
                if(isGreaterThan(arrayListString.get(i),arrayListString.get(j))){
                    temp = arrayListString.get(i);
                    arrayListString.set(i,arrayListString.get(j));
                    arrayListString.set(j,temp);
                }
            }
        }

        int n=0;
        int k=0;
        for (int i = 0; i < array.length; i++) {
            if(isNumber(array[i])){
                array[i] = arrayListInteger.get(n).toString();
                n++;
            }
            else {
                array[i] = arrayListString.get(k);
                k++;
            }
        }

    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }

    //строка - это на самом деле число? проверка строки
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
