package com.javarush.test.level15.lesson12.home05;

/**
 * Created by rukoa on 05.01.2017.
 */
public class SubSolution extends Solution {
    public SubSolution() {
    }

    public SubSolution(String string) {
        super(string);
    }

    public SubSolution(Integer integer) {
        super(integer);
    }

    SubSolution(Character character) {
        super(character);
    }

    SubSolution(Object object) {
        super(object);
    }

    SubSolution(Double number) {
        super(number);
    }

    protected SubSolution(Float fl) {
        super(fl);
    }

    protected SubSolution(Short sh) {
        super(sh);
    }

    protected SubSolution(int Ast) {
        super(Ast);
    }

    private SubSolution(double dl){super(dl);}
    private SubSolution(short sh){super(sh);}
    private SubSolution(float fl){super(fl);}
}
