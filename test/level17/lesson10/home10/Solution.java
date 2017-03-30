package com.javarush.test.level17.lesson10.home10;

/* Посчитаем
2. Сделай так, чтобы результат успел посчитаться для всех элементов массива values НЕ используя Thread.sleep
2. Исправь synchronized блок так, чтобы массив values заполнился значением 2
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        counter1.join();
        counter2.join();
        counter3.join();
        counter4.join();

        for (int i = 2; i <= 100; i++) {
            if (values[i] != 2) {
                System.out.println("Массив values содержит элементы неравные 2");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (values) {
                    incrementCount();
                    values[getCount()]++;
                }

                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {}
            } while (getCount() < 100);
        }
    }
}
