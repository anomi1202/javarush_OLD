package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 2 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<String> listString = new ArrayList<>();
        ArrayList<String> listOut = new ArrayList<>();
        ArrayList<String> listObjParam = new ArrayList<>();

        int index = s.indexOf("?"); // нашли индекс "?"
        s = s.substring(index + 1); // оставляем только те элементы, которые справа от "?"

        //разделяем строки по &
        for (String tmp : s.split("&")) {
            listString.add(tmp);
        }

        //ищем обьекты с obj и заносим их значения в отельный массив
        for (String tmp : listString) {
            if (tmp.startsWith("obj=")){
                tmp = tmp.substring(tmp.indexOf("=")+1);
                listObjParam.add(tmp);
            }
        }

        //в массиве listString с разделенными строками по & удаляем все значния после = (если есть). включая "="
        for (String tmp : listString){
            int i = tmp.indexOf("=");
            if (i!= -1)
                listOut.add(tmp.substring(0,i));
            else listOut.add(tmp);
        }


        for (int i = 0; i < listOut.size()-1; i++) {
            System.out.print(listOut.get(i) + " ");
        }
        System.out.println(listOut.get(listOut.size()-1));
        System.out.println();

        if (!listObjParam.isEmpty()) {
            for (int i = 0; i < listObjParam.size(); i++) {
                try{
                    alert(Double.parseDouble(listObjParam.get(i)));
                }
                catch (Exception e){
                    alert(listObjParam.get(i));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
