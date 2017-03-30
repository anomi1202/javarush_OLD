package com.javarush.test.level16.lesson10.task02;

/* Отсчет на гонках
2. Разберись, что делает программа.
2. Реализуй логику метода run так, чтобы каждую секунду через пробел
выдавался отсчет начиная с countSeconds до 2, а потом слово [Марш!] (см примеры).
3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].
Пример для countSeconds=4 : [4 3 2 2 Прервано!]
4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
Пример для countSeconds=3 : [3 2 2 Марш!]
PS: метод sleep выбрасывает InterruptedException.
*/

public class Solution {
    public static volatile int countSeconds = 3;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        Thread.sleep(3500);
        clock.interrupt();
    }

    public static class RacingClock extends Thread {
        public RacingClock() {
            start();
        }

        public void run() {
            try {
                while (!currentThread().isInterrupted()) {
                    System.out.print(countSeconds + " ");
                    Thread.sleep(1000);
                    countSeconds--;
                    if (countSeconds == 0) {
                        System.out.println("Марш!");
                        break;
                    }
                }
            }
            catch (InterruptedException e){
                System.out.println("Прервано!");
            }
        }
    }
}
