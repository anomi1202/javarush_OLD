package com.javarush.test.level15.lesson12.home04;

/**
 * Created by rukoa on 05.01.2017.
 */
public class Sun implements Planet {

    private static Sun planet;

    private Sun(){}

    public static Sun getInstance(){
        if (planet == null)
            planet = new Sun();
        return planet;
    }
}
