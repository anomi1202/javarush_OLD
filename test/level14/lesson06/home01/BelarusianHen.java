package com.javarush.test.level14.lesson06.home01;

/**
 * Created by rukoa on 02.01.2017.
 */
class BelarusianHen extends Hen{
    int getCountOfEggsPerMonth(){
        return 5;
    }
    String getDescription(){
        return (super.getDescription() + " " +
                String.format("Моя страна - %s. Я несу %d яиц в месяц.",
                        Country.BELARUS, getCountOfEggsPerMonth()));
    }
}