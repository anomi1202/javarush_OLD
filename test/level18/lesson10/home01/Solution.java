package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception{
        String name = args[0];
        FileInputStream file = new FileInputStream(name);
        int count = 0;
        while(file.available() > 0){
            if (isWords(file.read())) {
                count++;
            }
        }

        file.close();
        System.out.println(count);
    }

    public static boolean isWords(int byteWord){
        String word = "abcdefghijklmnopqrstuvwxyz";
        char[] wordChar = word.toCharArray();
        boolean out = false;
        for (int i = 0; i < word.length(); i++) {
            if (byteWord == wordChar[i])
                out = true;
        }
        return out;
    }
}
