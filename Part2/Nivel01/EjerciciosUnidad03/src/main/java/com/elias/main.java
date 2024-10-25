package com.elias;

import Ejercicio01.Ejercicio01;
import Ejercicio02.Ejercicio02;
import Ejercicio03.Ejercicio03;
import Ejercicio04.Ejercicio04;
import Ejercicio05.Ejercicio05;
import Ejercicio06.Ejercicio06;
import Ejercicio07.Ejercicio07;

import java.io.IOException;
import java.io.InterruptedIOException;

public class main {
    public static void main( String[] args )
    {
        Ejercicio01.main(args);
        Ejercicio02.main(args);
        Ejercicio03.main(args);
        Ejercicio04.main(args);
        Ejercicio05.main(args);
        try {
            Process process = Runtime.getRuntime().exec("java -cp target/classes Ejercicio06.Ejercicio06");
            int exitCode = process.waitFor();
            System.out.println("Ejercicio06 exited with code: " + exitCode);
        } catch (IOException | InterruptedException e){
            e.printStackTrace();
        }
        Ejercicio07.main(args);
    }
}
