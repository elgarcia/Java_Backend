package com.elias;

import java.util.Random;
import java.util.stream.IntStream;

public class Main
{
    public static IntStream    getOdd() { return (IntStream.iterate(1, n -> n + 2));}
    public static void main( String[] args ) {


        /* CONSULTA 1 */
        System.out.println(getOdd().limit(100).sum());

        /* CONSULTA 2 */
        System.out.println(getOdd().filter(n -> n % 5 == 0).limit(21).average().getAsDouble());

        /* CONSULTA 3*/
        var x = new Random().nextInt(0, Integer.MAX_VALUE);
        System.out.println(getOdd().filter(n -> n % 7 == 0).skip(x).limit(1000).findFirst().getAsInt());
    }
}
