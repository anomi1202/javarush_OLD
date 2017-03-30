package com.javarush.test.level15.lesson12.home04;

/**
 * Created by rukoa on 05.01.2017.
 */
public class Earth implements Planet{

    private static Earth planet;

    private Earth(){}

    public static Earth getInstance(){
        if (planet == null)
            planet = new Earth();
        return planet;
    }
}
