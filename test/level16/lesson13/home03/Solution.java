package com.javarush.test.level16.lesson13.home03;

/* Рекурсивное создание нитей
2. Измени класс GenerateThread так, чтобы он стал нитью.
2. Создай конструктор GenerateThread, который должен:
2.2. Вызвать конструктор суперкласса с параметром String - номером созданной нити. Используй countCreatedThreads.
2.2. Запустить текущую нить.
2.3. Номер первой нити должен начинается с 2.
3. Переопредели метод toString, для этого внутри GenerateThread нажми Alt+Insert -> Override Methods. Начни печатать toString.
3.2. Метод toString должен возвращать № текущей нити и слово " created". Используй getName(). Пример: [8 created]
4. Пока количество созданных нитей меньше Solution.count метод run должен:
4.2. создать новую нить типа GenerateThread.
4.2. Вывести в консоль созданную в пункте 4.2. нить.
5. В итоге должно быть выведено в консоль 15 строк.
*/

public class Solution {
    static int count = 15;
    static volatile int countCreatedThreads;

    public static void main(String[] args) {
        System.out.println(new GenerateThread());
    }

    public static class GenerateThread extends Thread {

        public void run(){
            while(countCreatedThreads < count) {
                GenerateThread generateThread = new GenerateThread();
                System.out.println(generateThread);
                try {
                    generateThread.join();
                }
                catch (InterruptedException e){}
            }
        }

        public GenerateThread(){
            super(String.valueOf(++countCreatedThreads));
            start();
        }

        @Override
        public String toString() {
            return getName() + " created";
        }
    }
}
