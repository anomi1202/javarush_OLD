package com.javarush.test.level04.lesson06.task04;

/* Сравнить имена
Ввести с клавиатуры два имени, и если имена одинаковые вывести сообщение «Имена идентичны». Если имена разные, но их длины равны – вывести сообщение – «Длины имен равны».
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name1 = reader.readLine();
        String name2 = reader.readLine();

        if (name1.equals(name2))
            System.out.println("Имена идентичны");
        else {
            char[] name1char = name1.toCharArray();
            char[] name2char = name2.toCharArray();
            if (name1char.length == name2char.length)
                System.out.println("Длины имен равны");
        }






    }
}
