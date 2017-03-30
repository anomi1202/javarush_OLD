package com.javarush.test.level15.lesson09.task01;

import java.util.HashMap;
import java.util.Map;

/* Статики 2
В статическом блоке инициализировать labels 5 различными парами.
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();
    static {
        labels.put(1.0,"d");
        labels.put(1.10,"f");
        labels.put(1.1110,"g");
        labels.put(1.11110,"h");
        labels.put(1.111110,"y");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
