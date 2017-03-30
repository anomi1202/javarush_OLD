package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Ru on 08.01.2017.
 */
public class Plane implements Flyable {
    private int countPassagers;
    public void fly(){}

    public Plane(int countPassagers){
        this.countPassagers = countPassagers;
    }
}
