package com.javarush.test.level14.lesson08.bonus03;

/**
 * Created by Ru on 04.01.2017.
 */
class Singleton {

    private static Singleton singleton = new Singleton();

    static Singleton getInstance(){
        return singleton;
    }

    private Singleton(){}
}
