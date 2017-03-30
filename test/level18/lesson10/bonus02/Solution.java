package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();
        String param = args[0];

        //находим максимальный ID в файле и записываем в maxIdInfile
        BufferedReader fileIn = new BufferedReader(new FileReader(fileName));
        String lineFileIn;
        int maxIdInfile = Integer.MIN_VALUE;
        while ((lineFileIn = fileIn.readLine()) != null ) {
            if (!lineFileIn.isEmpty()) {
                String idLine = lineFileIn.substring(0, 8);
                maxIdInfile = Integer.parseInt(idLine.trim()) > maxIdInfile ? Integer.parseInt(idLine.trim()) : maxIdInfile;
            }
        }
        fileIn.close();


        if (args.length > 3) {
            if (param.equals("-c")) {
                String idOfCurrentProduct = String.format("%-8.8s",maxIdInfile+1);
                //вытаскиваем из args строки, отвечающие за productName и записываем в productName
                String productName = "";
                for (int i = 1; i < args.length - 2; i++)
                    productName += args[i] + " ";
                productName = String.format("%-30.30s",productName);
                String price = String.format("%-8.8s",args[args.length - 2]);
                String quantity = String.format("%-4.4s",args[args.length - 1]);
                String lineOut = idOfCurrentProduct + productName + price + quantity;

                FileWriter fileOut = new FileWriter(fileName, true);
                fileOut.write(lineOut);
                fileOut.close();
            }
        }

        rd.close();
    }
}
