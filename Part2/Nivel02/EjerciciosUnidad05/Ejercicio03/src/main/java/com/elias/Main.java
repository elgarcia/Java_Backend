package com.elias;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static String digitosQueNoEstanEn (List<Long> numeros) {
        StringBuilder  result = new StringBuilder();
        numeros.forEach(num -> result.append(num.toString()));
        String          digitos = Stream.of(result.toString().split(""))
                .distinct()
                .collect(Collectors.joining());
        return (Stream.of("0123456789".split(""))
                .filter(d -> !digitos.contains(d))
                .sorted()
                .collect(Collectors.joining()));
    }

    public static void main( String[] args ) {
        System.out.println(digitosQueNoEstanEn(List.of(1201L, 23045L)));
    }
}
