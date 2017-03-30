package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        String fileName = args[0];
        FileInputStream file = new FileInputStream(fileName);

        int[] asciiArray = new int[255];

        for (int i = 0; i < asciiArray.length; i++) {
            asciiArray[i] = 0;
        }

        while(file.available() > 0){
            asciiArray[file.read()] += 1;
        }

        for (int i = 0; i < asciiArray.length; i++) {
            if (asciiArray[i] != 0)
                System.out.println(new Character((char)i).toString() + " " + asciiArray[i]);
        }

        file.close();
    }
}
