package com.elias;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void main( String[] args ) {
        List<String> ciudades = List.of("Madrid", "Barcelona", "Sevilla", "Cádiz", "Bilbao", "Lugo");
        /* CONSULTA 1 */
        System.out.println(Arrays.toString(ciudades.stream()
                .sorted(Comparator.reverseOrder())
                .toArray(String[]::new)));

        System.out.println("");
        /* CONSULTA 2 */
        System.out.println(ciudades.stream().map(String::length).distinct().toList());

        System.out.println("");
        /*CONSULTA 3*/
        System.out.println(ciudades.stream().allMatch(city -> city.length() > 5));

        System.out.println("");
        /*CONSULTA 4 */

        System.out.println(Stream.of("abcdefghijklmnopqrstuvwx".split(""))
                .filter(letter -> !String.join("", ciudades)
                        .toLowerCase()
                        .contains(letter))
                .distinct()
                .sorted()
                .collect(Collectors.joining()));

        System.out.println("");
        /* CONSULTA 5*/
        Map<Character, List<String>>    test = new HashMap<>();
        ciudades.forEach(city -> test
                .put(city.charAt(0), ciudades.stream()
                        .filter(ct -> ct.startsWith(String.valueOf(city.charAt(0))))
                        .toList()));

        System.out.println(test.toString());
    }
}
