package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(rd.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();

        while (file.available() > 0){
            list.add(file.read());
            out.add(0);
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); ) {
                if (list.get(i) == list.get(j)){
                    out.set(i,out.get(i)+1);
                    out.remove(j);
                    list.remove(j);
                }
                else j++;
            }
        }

        int countOfMax = out.get(0);
        for (int i = 1; i < out.size() ; i++) {
            countOfMax = countOfMax > out.get(i) ? out.get(i) : countOfMax;
        }

        String text = "";
        while (out.indexOf(countOfMax) != -1){
            text += list.get(out.indexOf(countOfMax)) + " ";
            out.set(out.indexOf(countOfMax),countOfMax - 1);
        }
        text = text.substring(0,text.length()-1);
        System.out.print(text);

        rd.close();
        file.close();
    }
}
