package com.javarush.test.level16.lesson13.home02;

/* Последовательные выполнения нитей
2. В методе run после всех действий поставь задержку в 10 миллисекунд. Выведи "Нить прервана", если нить будет прервана.
2. Сделай так, чтобы все нити выполнялись последовательно: сначала для нити №2 отсчет с COUNT до 2, потом для нити №2 с COUNT до 2 и т.д.
Пример:
#2: 4
#2: 3
...
#2: 2
#2: 4
...
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            SleepingThread sleepingThread = new  SleepingThread();
            sleepingThread.join();
            //Thread.currentThread().interrupt();
        }

    }

    public static class SleepingThread extends Thread {
        private volatile int countDownIndex = COUNT;
        private static volatile int threadCount = 0;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            try {
                while (true) {
                    System.out.println(this);
                    if (--countDownIndex == 0) return;
                    Thread.sleep(10L);
                }
            }
            catch(InterruptedException e){
                System.out.println("Нить прервана");
                return;
            }
        }


        public String toString() {
            return "#" + getName() + ": " + countDownIndex;
        }
    }
}
