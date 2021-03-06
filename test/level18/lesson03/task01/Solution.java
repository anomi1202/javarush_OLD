package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(rd.readLine());

        int maxByte = file.read();
        while (file.available()>0){
            int by = file.read();
            maxByte = by > maxByte ? by : maxByte;
        }
        System.out.println(maxByte);

        file.close();
        rd.close();
    }
}
