package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        String fileName;

        while (!(fileName = rd.readLine()).equals("exit")){
            new ReadThread(fileName).start();
        }
        rd.close();
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run(){
            ArrayList<Integer> byteList = new ArrayList<>();
            try {

                FileInputStream file = new FileInputStream(fileName);

                while (file.available() > 0)
                    byteList.add(file.read());

                int MAXBYTECOUNTOUT = 0;
                int indexMaxByte = 0;
                for (int i = 0; i < byteList.size(); i++) {
                    int byteCountTemp = Collections.frequency(byteList,byteList.get(i));
                    if (byteCountTemp > MAXBYTECOUNTOUT) {
                        MAXBYTECOUNTOUT = byteCountTemp;
                        indexMaxByte = i;
                    }
                }

                resultMap.put(fileName, byteList.get(indexMaxByte));
                file.close();
            }
            catch (FileNotFoundException e) {}
            catch (IOException e) {}
        }
    }
}
