package com.elias;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static <N extends Number, T extends CharSequence> T Procesar(N number, List<T> texts){
        int size = number.intValue();

        for(T text: texts)
        {
            if (text.length() == size)
                return (text);
        }
        return (null);
    }

    public static void main( String[] args ) {
        double  a = 30.2;
        int     b = 8;
        List<String>    sequence = new ArrayList<>();

        sequence.add("Hola");
        sequence.add("Buenos");
        sequence.add("Cuadrado");
        System.out.println(Procesar(b, sequence));
    }
}
