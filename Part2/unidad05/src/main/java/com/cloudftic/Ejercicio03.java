package com.cloudftic;

import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.Data;

/*
Crea el siguiente método:

public static String digitosQueNoEstanEn (List<Long> numeros) { 
}

Recibe como argumento una lista de números enteros. Debe retornar un
string formado por aquellos dígitos (en orden ascendente) que no aparezcan
en ninguno de los números que hay dentro de la lista. Si los números
incluyen todos los dígitos (del 0 al 9) debe retornar un string vacío.
Por ejemplo, si numeros=[1201, 23045], debe retornar "6789".
 */

public class Ejercicio03 {

    public static void main(String[] args) {
        System.out.println(digitosQueNoEstanEn(List.of(1201L, 23045L)));
    }

    public static String digitosQueNoEstanEn(List<Long> numeros) {
        final List<String> digitos = numeros.stream()
                .map(n -> String.valueOf(n)) // Convierte 12 a "12"
                .map(n -> n.split("")) // Convierte "12" a {"1", "2"}
                .flatMap(array -> Stream.of(array)) // Junta todos los digitos
                .distinct() // Elimina repetidos
                .toList();
        return Stream.of("0123456789".split(""))
                .filter(d -> !digitos.contains(d))  // Se queda con los que no estan en los numeros
                .sorted()    // Ordena
                .collect(Collectors.joining())   // Junta los digitos en un string
                ;
    }
}
