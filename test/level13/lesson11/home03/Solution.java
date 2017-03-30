package com.javarush.test.level13.lesson11.home03;

/* Чтение файла
2. Считать с консоли имя файла.
2. Вывести в консоль(на экран) содержимое файла.
3. Не забыть освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();

        FileInputStream inFile = new FileInputStream(nameFile);
        while(inFile.available() > 0){
            System.out.print((char)inFile.read());
        }

        inFile.close();
    }
}
