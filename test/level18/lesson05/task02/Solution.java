package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileInputStream file = new FileInputStream(rd.readLine());
            char[] ascii = (",").toCharArray();

            int count = 0;
            while(file.available() > 0){
                if(ascii[0] == (char) file.read())
                    count++;
            }
            System.out.println(count);

            file.close();
            rd.close();
        }
        catch (IOException e){}
    }
}
