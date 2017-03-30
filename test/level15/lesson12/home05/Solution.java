package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
2. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

import org.omg.CORBA.FloatSeqHelper;

import java.util.Objects;

public class Solution {

    public Solution(){}
    public Solution(String string){}
    public Solution(Integer integer){}

    Solution(Character character){}
    Solution(Object  object){}
    Solution(Double number){}

    protected Solution(Float fl){}
    protected Solution(Short  sh){}
    protected Solution(int Ast){}

    private Solution(double dl){}
    private Solution(short sh){}
    private Solution(float fl){}
}

