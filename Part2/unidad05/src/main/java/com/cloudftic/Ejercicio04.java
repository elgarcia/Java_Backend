package com.cloudftic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Crea una lista de ciudades como la siguiente:

List<String> ciudades = List.of("Madrid", "Barcelona", "Sevilla", "Cádiz", "Bilbao", "Lugo");

Resuelve las siguientes consultas usando operaciones funcionales:
 */

public class Ejercicio04 {

    public static void main(String[] args) {
        List<String> ciudades = List.of("Madrid", "Barcelona", "Sevilla", "Cádiz", "Bilbao", "Lugo");

        // Obtén un array de strings con las ciudades ordenadas alfabéticamente de mayor
        // a menor.
        System.out.println(Arrays.toString(
                ciudades.stream()
                        .sorted(Comparator.reverseOrder())
                        .toArray(String[]::new)
                        )
                        );

        // Obtén una lista de longitudes de los nombres de las ciudades, sin repetidos.
        System.out.println(
            ciudades.stream()
                    .map(String::length)    //.map(ciudad -> ciudad.length())
                    .distinct()
                    .toList()
                    );

        // Obtén un valor booleano (true o false) que indique si todos los nombres de
        // ciudad pasan de 5 caracteres.
        System.out.println(
            ciudades.stream()
                    .mapToInt(String::length)     //.map(ciudad -> ciudad.length())
                    .allMatch( n -> n>5 )
                    );

        // Junta todos los caracteres de los nombres de ciudades, eliminando caracteres
        // repetidos, y devuelve un string con dichos caracteres ordenados
        // alfabéticamente.
        System.out.println(
            ciudades.stream()
                    .map(ciudad -> ciudad.split(""))
                    .flatMap( s -> Stream.of(s))
                    .distinct()
                    .sorted()
                    .collect(Collectors.joining())
                    );

        // Obtén un Map<Character, List<String>>, cuyas claves serán las iniciales de
        // los nombres de ciudades, y el valor serán una lista de aquellas ciudades 
        // que comienzan por la inicial dada por la clave.
        System.out.println(
            ciudades.stream()
                    .collect(Collectors.groupingBy(c -> c.charAt(0)))
                    );

    }

}
