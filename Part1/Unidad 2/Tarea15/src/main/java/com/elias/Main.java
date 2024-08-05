package com.elias;

import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main( String[] args ) {
        List<Funcion>   functions = new ArrayList<>();
        Cuadrado        c = new Cuadrado("x");
        Media           m = new Media("x");
        AreaCircular    ac = new AreaCircular("x");

        functions.add(c);
        functions.add(m);
        functions.add(ac);

        for (int i = 1; i <= 50; i++){
            for (var f: functions){
                System.out.println(f.getFormula() + " para el valor " + i + " es " + f.calcular(i));
            }
        }
    }
}
