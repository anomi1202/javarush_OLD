package com.javarush.test.level05.lesson12.bonus03;

import java.io.*;

/* Задача по алгоритмам
Написать программу, которая:
2. вводит с консоли число N > 0
2. потом вводит N чисел с консоли
3. выводит на экран максимальное из введенных N чисел.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int maximum = Integer.parseInt(reader.readLine());
        int[] array = new int[maximum];

        for (int i=0;i<maximum;i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }
        if (maximum>1){
            maximum = max(array[0],array[1]);
            for (int i=2;i< array.length;i++){
                maximum = max(maximum,array[i]);
            }
            System.out.println(maximum);
        }
        else System.out.println(array[0]);
    }

    public static int max(int a,int b){
        return a>b?a:b;
    }
}
