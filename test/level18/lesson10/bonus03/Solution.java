package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName = rd.readLine();


        if (args.length > 0) {
            switch (args[0]) {
                case "-u":
                    String[] newParam = new String[args.length-1];
                    for (int i = 1; i < args.length; i++) {
                        newParam[i-1] = args[i];
                    }
                    updateLine(fileName, newParam);
                    break;
                case "-d":
                    deleteLine(fileName, args[1]);
                    break;
                default:
                    break;
            }
        }

        rd.close();
    }

    //-d id
    //удалить строку с номером = id
    public static void deleteLine(String fileName, String id) throws IOException{
        File sourceFile = new File(fileName);
        File outFile = new File(fileName + "FILECOPY");
        BufferedReader sourceFileBuff = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter outFileBuff = new BufferedWriter(new FileWriter(outFile));

        String line;
        while((line = sourceFileBuff.readLine()) != null){
            String lineID = line.substring(0,8).trim();
            if (!lineID.equals(id)){
                outFileBuff.write(line);
                outFileBuff.newLine();
            }
        }

        sourceFileBuff.close();
        outFileBuff.close();
        sourceFile.delete();
        outFile.renameTo(sourceFile);
    }

    /*-u id productName price quantity - обвновить строку с номером = id
    Значения параметров:
    где id - 8 символов
    productName - название товара, 30 chars (60 bytes)
    price - цена, 8 символов
    quantity - количество, 4 символа*/
    public static void updateLine(String fileName, String[] newParam)throws IOException{
        File sourceFile = new File(fileName);
        File outFile = new File(fileName + "FILECOPY");
        BufferedReader sourceFileBuff = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter outFileBuff = new BufferedWriter(new FileWriter(outFile));
        String id = newParam[0];

        String line;
        while((line = sourceFileBuff.readLine()) != null){
            String lineID = line.substring(0,8);
            if (lineID.trim().equals(id)){
                String newProductName = "";
                for (int i = 1; i < newParam.length - 2 ; i++) {
                    newProductName += newParam[i];
                }
                newProductName = String.format("%-30.30s", newProductName);
                String newPrice = String.format("%-8.8s", newParam[newParam.length - 2]);
                String newQuantity = String.format("%-4.4s", newParam[newParam.length - 1]);
                String outLine = lineID + newProductName + newPrice + newQuantity;
                outFileBuff.write(outLine);
                outFileBuff.newLine();
            }
            else {
                outFileBuff.write(line);
                outFileBuff.newLine();
            }
        }

        sourceFileBuff.close();
        outFileBuff.close();
        sourceFile.delete();
        outFile.renameTo(sourceFile);
    }
}
