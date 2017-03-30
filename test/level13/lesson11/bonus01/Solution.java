package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
2. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String nameFile = reader.readLine();
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader fileReader = new BufferedReader(new FileReader(nameFile));
        while(fileReader.ready()){
            int temp = Integer.parseInt(fileReader.readLine());
            if (temp %2 == 0)
                list.add(temp);
        }

        for (int i = 0; i < list.size(); i++) {
            int temp;
            for (int j = i+1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)){
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                }
            }
        }

        for (Integer out : list){
            System.out.println(out);
        }
    }
}
