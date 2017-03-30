package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] a = {Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine())};

        int Nmax=0;
        int Nmin=0;
        for (int i=1;i<a.length;i++){
            if (a[i]>a[Nmax])
                Nmax=i;
            if (a[i]<a[Nmin])
                Nmin=i;
        }
        for (int i=0;i<a.length;i++){
            if (i!=Nmax && i!=Nmin){
                System.out.println(a[i]);
            break;
            }
        }
    }
}
