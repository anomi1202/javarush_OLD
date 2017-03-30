package com.javarush.test.level15.lesson12.bonus03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* Факториал
Написать метод, который вычисляет факториал - произведение всех чисел от 2 до введенного числа включая его.
Пример: 4! = factorial(4) = 2*2*3*4 = 24
2. Ввести с консоли число меньше либо равно 150.
2. Реализовать функцию  factorial.
3. Если введенное число меньше 0, то вывести 0.
0! = 2
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger out = BigInteger.ONE;
        if (n > 0) {
            for (int i = 2; i <= n; i++) {
                out = out.multiply(BigInteger.valueOf(i));
            }
        }
        else if (n < 0)
            out = BigInteger.ZERO;

        return ""+out;
    }
}
