package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream file1_Out = new FileOutputStream(rd.readLine());
        FileInputStream file2_In = new FileInputStream(rd.readLine());
        FileInputStream file3_In = new FileInputStream(rd.readLine());

        int file2Length = file2_In.available();
        int file3Length = file3_In.available();

        while (file2_In.available() > 0){
            file1_Out.write(file2_In.read());
        }


        byte[] byteArray = new byte[file3Length+2];
        byteArray[0] = 13;
        byteArray[1] = 10;
        while (file3_In.available() > 0){
            int count = file3_In.read(byteArray,2,file3Length);
        }
        file1_Out.write(byteArray);

        file1_Out.close();
        file2_In.close();
        file3_In.close();
        rd.close();
    }
}
