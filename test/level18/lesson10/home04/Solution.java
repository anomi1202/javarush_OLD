package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String file1 = rd.readLine();
        String file2 = rd.readLine();

        FileInputStream file1_IN = new FileInputStream(file1);
        FileInputStream file2_IN = new FileInputStream(file2);

        int file1Length = file1_IN.available();
        int file2Length = file2_IN.available();

        byte[] outArray = new byte[file1Length + file2Length + 2];

        while(file2_IN.available() > 0){
            file2_IN.read(outArray);
        }

        outArray[file2Length] = 13;
        outArray[file2Length+1] = 10;

        while(file1_IN.available()> 0){
            file1_IN.read(outArray,file2Length+2,file1Length);
        }

        FileOutputStream file1_Out = new FileOutputStream(file1);
        file1_Out.write(outArray);

        rd.close();
        file1_Out.close();
        file1_IN.close();
        file2_IN.close();
    }
}
