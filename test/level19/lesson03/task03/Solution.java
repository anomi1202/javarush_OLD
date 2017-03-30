package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }



    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData incomeData;

        public IncomeDataAdapter(IncomeData incomeData) {
            this.incomeData = incomeData;
        }

        @Override
        public String getName() {
            //example Ivanov, Ivan
            String name = "";
            name = incomeData.getContactLastName() + ", " + incomeData.getContactFirstName();
            return name;
        }

        @Override
        public String getPhoneNumber() {
            String phoneNumber = "";
            //example +38(050)123-45-67
            String phoneNumberWithoutCode = incomeData.getPhoneNumber() + "";
            if (phoneNumberWithoutCode.length() < 10)
                for (int i = phoneNumberWithoutCode.length(); i < 10; i++) {
                    phoneNumberWithoutCode = "0" + phoneNumberWithoutCode;
                }
            phoneNumber = "+" + incomeData.getCountryPhoneCode() +
                    "(" + phoneNumberWithoutCode.substring(0,3) + ")" +
                    phoneNumberWithoutCode.substring(3,6) + "-" +
                    phoneNumberWithoutCode.substring(6,8) + "-" +
                    phoneNumberWithoutCode.substring(8);
            return phoneNumber;
        }

        @Override
        public String getCompanyName() {
            //example JavaRush Ltd.
            return incomeData.getCompany();
        }

        @Override
        public String getCountryName() {
            //example Ukraine
            String countryCode = incomeData.getCountryCode();
            String country = "";
            for (Map.Entry<String, String> pair : countries.entrySet()){
                if (pair.getKey().equals(countryCode)){
                    country = pair.getValue();
                }
            }
            return country;
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}