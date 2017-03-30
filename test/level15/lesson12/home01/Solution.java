package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
2. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.2. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = reader.readLine();
            if (s.equals("exit"))
                break;
            try {
                Double.parseDouble(s);
                boolean m = false;
                char[] charS = s.toCharArray();

                for (int i = 0; i < charS.length; i++) {
                    if (charS[i] == '.') {
                        m = true;
                        break;
                    }
                }
                if (m)
                    print(Double.parseDouble(s));
                else if (Integer.parseInt(s) > 0 && Integer.parseInt(s) < 128)
                    print((short) Integer.parseInt(s));
                else if (Integer.parseInt(s) >= 128 || Integer.parseInt(s) == 0)
                    print((int) Integer.parseInt(s));
            }
            catch (NumberFormatException e) {
                print(s);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
