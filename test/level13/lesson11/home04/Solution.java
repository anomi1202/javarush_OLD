package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
2. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String nameFile = reader.readLine();
        File file = new File(nameFile);
        PrintWriter outFile = new PrintWriter(file.getAbsoluteFile());

        ArrayList<String> list = new ArrayList<>();

        while (true) {
            String string = reader.readLine();
            if (string.equals("exit")) {
                list.add(string);
                break;
            }
            else list.add(string);
        }

        for (String out : list) {
            outFile.println(out);
        }

        outFile.close();
    }
}
