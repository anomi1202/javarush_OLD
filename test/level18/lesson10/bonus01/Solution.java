package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        String param = args[0];
        String fileInName = args[1];
        String fileOutputName = args[2];

        if (param.equals("-e"))
            cripto(fileInName, fileOutputName);
        else decripto(fileInName, fileOutputName);
    }

    public static void cripto(String fileInName, String fileOutputName) throws IOException{
        BufferedReader fileIn = new BufferedReader(new FileReader(fileInName));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileOutputName));

        String lineIn;
        while ((lineIn = fileIn.readLine()) != null){
            fileOut.write(lineIn + lineIn + "\n");
            fileOut.flush();
        }

        fileIn.close();
        fileOut.close();
    }

    public static void decripto(String fileInName, String fileOutputName) throws IOException{
        BufferedReader fileIn = new BufferedReader(new FileReader(fileInName));
        BufferedWriter fileOut = new BufferedWriter(new FileWriter(fileOutputName));

        String lineIn;
        while ((lineIn = fileIn.readLine()) != null){
            lineIn = lineIn.substring(0,lineIn.length()/2) + "\n";
            fileOut.write(lineIn);
            fileOut.flush();
        }

        fileIn.close();
        fileOut.close();
    }
}
