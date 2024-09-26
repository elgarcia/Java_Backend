package com.cloudftic;

import java.util.Random;
import java.util.stream.IntStream;

/*
Crea un IntStream que represente un flujo infinito de los números impares
positivos. A continuación resuelve las siguientes consultas mediante 
operaciones funcionales sobre este flujo:
 */

public class Ejercicio05 {

    private static IntStream getImpares() {
        return IntStream.iterate(1, n -> n + 2);
    }

    public static void main(String[] args) {
        // Obtén la suma de los primeros 100 impares del flujo. (El resultado debe
        // ser 10000)
        System.out.println(
                getImpares()
                        .limit(100)
                        .sum());

        // Filtra por los primeros 21 números múltiplos de 5 y obtén su valor medio.
        // (El resultado debe ser 105.0)
        System.out.println(
                getImpares()
                        .filter(n -> n % 5 == 0)
                        .limit(21)
                        .average().getAsDouble()
                        );

        // Define una variable x y asígnale un número entero al azar mayor o igual
        // que cero . A continuación obtén el primer impar que sea múltiplo de 7
        // ubicado dentro del flujo entre las posiciones x y x+10000 (inclusive).
        // Se piden posiciones concretas de los elementos del flujo, no valores
        // concretos.
        int x = new Random().nextInt(0, Integer.MAX_VALUE);
        System.out.println(
                getImpares()
                        .filter(n -> n % 7 == 0)
                        .skip(x)
                        .limit(10000)
                        .findFirst().getAsInt()
                        );

    }

}
