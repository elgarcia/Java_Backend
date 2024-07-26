package com.elias;

import java.util.List;

public class Main
{
    public static void main( String[] args ) {
        MayorImpar m = new MayorImpar(List.of(2, 4, 5, 12, 41));
        System.out.println(m.consumir());
    }
}
