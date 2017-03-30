package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -2, вывести на экран сумму и завершить программу.  -2 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a=0;
        while (a!=-1){
            int k=Integer.parseInt(reader.readLine());
            if (k==-1)
            {
                a += k;
                break;
            }
            a+=k;
        }
        System.out.println(a);
    }
}
