package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = "C:\\Users\\Ru\\Desktop\\JavaRushHomeWork\\JavaRushHomeWork\\src\\com\\javarush\\test\\level19\\lesson03\\task04\\1";
        PersonScannerAdapter psa = new PersonScannerAdapter(new Scanner(new File(fileName)));

        System.out.println(psa.read());
        psa.close();
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner scanner;

        public PersonScannerAdapter (Scanner scanner){
            this.scanner = scanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
            //В файле хранится большое количество людей, данные одного человека находятся в одной строке.
            //Метод read() должен читать данные одного человека.
            //Данные в файле хранятся в следующем виде: Иванов Иван Иванович 31 12 1950
            Person person = null;

            String line = "";
            if (scanner.hasNext())
                line = scanner.nextLine();
            String lastName = line.split(" ")[0];
            String firstName = line.split(" ")[1];
            String middleName = line.split(" ")[2];
            String birthDt = line.split(" ")[3] + " " + line.split(" ")[4] + " " + line.split(" ")[5];
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = dateFormat.parse(birthDt);

            person = new Person(firstName, middleName, lastName, birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            scanner.close();
        }
    }
}
