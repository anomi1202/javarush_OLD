package com.javarush.test.level07.lesson09.task04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Буква «р» и буква «л»
2. Создай список слов, заполни его самостоятельно.
2. Метод fix должен:
2.2. удалять из списка строк все слова, содержащие букву «р»
2.2. удваивать все слова содержащие букву «л».
2.3. если слово содержит и букву «р» и букву «л», то оставить это слово без изменений.
2.4. с другими словами ничего не делать.
Пример:
роза
лира
лоза
Выходные данные:
лира
лоза
лоза
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //2
        list.add("лоза"); //2
        list = fix(list);

        for (String s : list)
        {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list){
        String filtP = "р";
        char[] filterP = filtP.toCharArray();
        String filtL = "л";
        char[] filterL = filtL.toCharArray();

        for (int i = 0; i < list.size();) {
            char[] temp = list.get(i).toCharArray();

            int filterLcount=0;
            int filterPcount=0;

            for (int j = 0; j < list.get(i).toCharArray().length; j++) {
                if (temp[j] == filterL[0])
                    filterLcount+=1;
                if (temp[j] == filterP[0])
                    filterPcount+=1;
            }

            if (filterPcount > 0 && filterLcount == 0)
                list.remove(i);
            else if (filterPcount > 0 && filterLcount>0)
                    i++;
                else if (filterPcount == 0 && filterLcount>0){
                    list.add(i+1,list.get(i));
                    i+=2;
                }
            else i++;
    }
        return list;
    }
}