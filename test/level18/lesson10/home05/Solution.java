package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws  Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        String fileName1 = rd.readLine();
        String fileName2 = rd.readLine();

        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedWriter file2 = new BufferedWriter(new FileWriter(fileName2));

        String fileLineIN = file1.readLine();
        String[] fileArray = fileLineIN.split(" ");
        String fileLineOUT = "";

        for (int i = 0; i < fileArray.length; i++) {
            if (i == fileArray.length-1)
                fileLineOUT += Math.round(Float.parseFloat(fileArray[i])) + "";
            else fileLineOUT += Math.round(Float.parseFloat(fileArray[i])) + " ";
        }

        file2.write(fileLineOUT);

        rd.close();
        file1.close();
        file2.close();
    }
}
