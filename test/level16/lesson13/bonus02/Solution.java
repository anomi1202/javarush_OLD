package com.javarush.test.level16.lesson13.bonus02;

import sun.security.krb5.internal.TGSRep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
2. Создай 5 различных своих нитей c отличным от Thread типом:
2.2. нить 2 должна бесконечно выполняться;
2.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
2.3. нить 3 должна каждые полсекунды выводить "Ура";
2.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
2.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

    public static class Thread1 extends Thread{
        public Thread1(){}

        public void run(){
            while(true){}
        }
    }

    public static class Thread2 extends Thread{
        public Thread2(){}

        public void run(){
            try {
                while (true) {
                    Thread.sleep(1);
                }
            }
            catch (InterruptedException e){
                System.out.println("InterruptedException");
            }
        }
    }

    public static class Thread3 extends Thread{
        public Thread3(){}

        public void run(){
            try {
                while (true) {
                    System.out.println("Ура1");
                    Thread.sleep(500);
                }
            }
            catch(InterruptedException e){}
        }
    }

    public static class Thread4 extends Thread implements Message{
        public Thread4(){}

        public void showWarning(){
            this.interrupt();
            try {
                this.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

        public void run(){
            try {
                while (!isInterrupted()) {
                    Thread.sleep(1);
                }
            }
            catch(InterruptedException e){}
        }
    }

    public static class Thread5 extends Thread{
        private int summ = 0;
        public Thread5() {}

        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try{
                String text = "";
                while(!(text = reader.readLine()).equals("N")){
                    summ += Integer.parseInt(text);
                }
                System.out.println(summ);
            }
            catch (Exception e){}
            finally {
                try {
                    reader.close();
                }
                catch (IOException e) {}
            }
        }
    }
}
