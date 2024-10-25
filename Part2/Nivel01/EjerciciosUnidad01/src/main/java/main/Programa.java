package main;

import ejercicios.*;

public class Programa {
    public static void main(String[] args) {
        int ejercicio = -1;

        while (ejercicio != 8) {
            ejercicio = Consola.readInteger("Elije ejercico a ver (8 para salir): ");
            switch (ejercicio) {
                case 1:
                    Ejercicio01.main(args);
                    break;
                case 2:
                    Ejercicio02.main(args);
                    break;
                case 3:
                    Ejercicio03.main(args);
                    break;
                case 4:
                    Ejercicio04.main(args);
                    break;
                case 5:
                    Ejercicio05.main(args);
                    break;
                case 6:
                    Ejercicio06.main(args);
                    break;
                case 7:
                    Ejercicio07.main(args);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Ejercicio no valido!");
                    break;
            }
        }

    }
}