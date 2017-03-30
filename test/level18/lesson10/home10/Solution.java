package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> fileNameList = new ArrayList<>();
        String fileName;

        while(!(fileName = rd.readLine()).equals("end")){
            fileNameList.add(fileName);
        }
        Collections.sort(fileNameList);

        String fileNameOut = fileNameList.get(0).substring(0,fileNameList.get(0).lastIndexOf("."));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileNameOut));

        for (int i = 0; i < fileNameList.size(); i++) {
            BufferedReader fileIN = new BufferedReader(new FileReader(fileNameList.get(i)));
            String fileINString;
            while((fileINString = fileIN.readLine()) != null){
                fileOut.write(fileINString);
            }
            fileOut.flush();
            fileIN.close();
        }

        fileOut.close();
        rd.close();
    }
}
