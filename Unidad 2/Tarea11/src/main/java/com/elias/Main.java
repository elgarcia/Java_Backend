package com.elias;

public class Main 
{
    public static void main( String[] args ) {
        Sumatorio   suma1 = Sumatorio.builder()
                .setMin(2)
                .setMax(4)
                .addNumber(2.3)
                .addNumber(1.4)
                .addNumber(10)
                .addNumber(9.1)
                .addNumber(5.32)
                .build();

        System.out.println(suma1.getSuma());
    }
}
