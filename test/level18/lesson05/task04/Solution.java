package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileInputStream file = new FileInputStream(rd.readLine());
            FileOutputStream fileOut = new FileOutputStream(rd.readLine());

            byte[] buff = new byte[file.available()];
            int count = 0;
            while (file.available() > 0){
                count = file.read(buff);
            }

            byte[] buffOut = new byte[count];
            for (int i = 0; i < buff.length; i++) {
                buffOut[i] = buff[buff.length-i-1];
            }
            fileOut.write(buffOut);

            fileOut.close();
            file.close();
            rd.close();
        }
        catch (IOException e){}
    }
}
