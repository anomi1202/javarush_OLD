package com.javarush.test.level15.lesson12.home04;

/**
 * Created by rukoa on 05.01.2017.
 */
public class Moon implements Planet {

    private static Moon planet;

    private Moon(){}

    public static Moon getInstance(){
        if (planet == null)
            planet = new Moon();
        return planet;
    }
}
