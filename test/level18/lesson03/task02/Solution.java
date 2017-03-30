package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(rd.readLine());

        int minByte = file.read();
        while (file.available()>0){
            int by = file.read();
            minByte = by < minByte ? by : minByte;
        }
        System.out.println(minByte);

        file.close();
        rd.close();
    }
}
