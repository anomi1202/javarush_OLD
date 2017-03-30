package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
2. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws Exception{
        String fileName = args[0];
        FileInputStream file = new FileInputStream(fileName);

        int countSpace = 0;
        int countSymbols = file.available();
        while (file.available() > 0) {
            if (isSpace(file.read()))
                countSpace++;
        }

        float result = ((float) countSpace / (float) countSymbols) * 100;
        System.out.println(String.format(Locale.ENGLISH, "%.2f",result));
        file.close();

    }

    public static boolean isSpace(int symbol){
        boolean out = false;
        char[] space = " ".toCharArray();
        if (symbol == space[0])
            out = true;
        return out;
    }
}
