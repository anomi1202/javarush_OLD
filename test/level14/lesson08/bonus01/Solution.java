package com.javarush.test.level14.lesson08.bonus01;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {
        //2 - it's first exception
        try {float i = 1 / 0;}
        catch (Exception e) {exceptions.add(e);}

        //2
        try{
            int[] array = new int[2];
            array[3] = 3;
        }
        catch (Exception e){ exceptions.add(e);}
        //3
        try{
            int[] array;
            int a = -4;
            array = new int[a];
        }
        catch (Exception e){ exceptions.add(e);}
        //4
        try{
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < 10; i++)
                list.add(i);
            list.get(20);
        }
        catch (Exception e){exceptions.add(e);}
        //5
        try{
            HashMap<Integer, String> map = new HashMap<>();
            for (int i = 0; i < 5; i++)
                map.put(i,""+i);
            for (Map.Entry<Integer,String> pair :map.entrySet()) {
                map.remove(pair.getKey());
            }
        }
        catch (Exception e){exceptions.add(e);}
        //6
        try {
            Object unknownObject = null;
            if(unknownObject.equals("knownObject"))
                System.out.println("");
        }
        catch (Exception e) {exceptions.add(e);}
        //7
        try {float i = 1 / 0;}
        catch (Exception e) {exceptions.add(e);}
        //8
        try {float i = 1 / 0;}
        catch (Exception e) {exceptions.add(e);}
        //9
        try {float i = 1 / 0;}
        catch (Exception e) {exceptions.add(e);}
        //10
        try {float i = 1 / 0;}
        catch (Exception e) {exceptions.add(e);}

    }
}
