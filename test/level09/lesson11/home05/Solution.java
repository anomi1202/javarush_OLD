package com.javarush.test.level09.lesson11.home05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Гласные и согласные буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа должна вывести на экран две строки:
2. первая строка содержит только гласные буквы
2. вторая - только согласные буквы и знаки препинания из введённой строки.
Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.

Пример ввода:
Мама мыла раму.
Пример вывода:
а а ы а а у
М м м л р м .
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        ArrayList<Character> textVowel = new ArrayList<>();
        ArrayList<Character> textNoVowel = new ArrayList<>();
        char[] sChar = s.toCharArray();
        char[] paste = new char[]{' '};
        for (int i = 0; i < sChar.length; i++) {
            if (isVowel(sChar[i]))
                  textVowel.add(s.toCharArray()[i]);
            else if (sChar != paste)
                textNoVowel.add(s.toCharArray()[i]);
        }

        for (int i = 0; i < textVowel.size(); i++) {
            System.out.print(textVowel.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < textNoVowel.size(); i++) {
            System.out.print(textNoVowel.get(i) + " ");
        }
    }


    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    //метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels){//ищем среди массива гласных
            if (c == d)
                return true;
        }
        return false;
    }
}
