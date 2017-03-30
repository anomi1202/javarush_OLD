package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));

        try {
            FileInputStream file1 = new FileInputStream(rd.readLine());
            FileOutputStream file2 = new FileOutputStream(rd.readLine());
            FileOutputStream file3 = new FileOutputStream(rd.readLine());

            if (file1.available() % 2 == 0) {
                System.out.println(file1.available());
                byte[] buff1 = new byte[file1.available() / 2];
                byte[] buff2 = new byte[file1.available() / 2];
                int count1 = file1.read(buff1,0,buff1.length);
                System.out.println(file1.available());
                int count2 = file1.read(buff2);
                file2.write(buff1, 0, count1);
                file3.write(buff2, 0, count2);
            }
            else {
                System.out.println(file1.available());
                byte[] buff1 = new byte[file1.available() / 2+1];
                byte[] buff2 = new byte[file1.available() / 2];
                int count1 = file1.read(buff1,0,buff1.length);
                System.out.println(file1.available());
                int count2 = file1.read(buff2);
                file2.write(buff1, 0, count1);
                file3.write(buff2, 0, count2);
            }

            rd.close();
            file1.close();
            file2.close();
            file3.close();
        }
        catch (IOException e){}
    }
}
