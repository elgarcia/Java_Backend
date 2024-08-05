package com.elias;

import java.util.Arrays;

public class Main
{
    public static void main( String[] args ) {
        Suma s = new Suma(3.0, 4.5, 2);
        System.out.println(s.getFormula());
        System.out.println(s.getOperand(1));
    }
}
