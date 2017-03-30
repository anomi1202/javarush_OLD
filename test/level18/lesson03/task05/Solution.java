package com.javarush.test.level18.lesson03.task05;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(rd.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        while(file.available() > 0){
            list.add(file.read());
        }

        int temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i+1; j < list.size(); ) {
                if (list.get(i) > list.get(j)) {
                    temp = list.get(i);
                    list.set(i,list.get(j));
                    list.set(j,temp);
                    j++;
                }
                else if (list.get(i) == list.get(j))
                    list.remove(j);
                else j++;
            }
        }

        for (Integer out:list) {
            System.out.print(out + " ");
        }

        rd.close();
        file.close();
    }
}
