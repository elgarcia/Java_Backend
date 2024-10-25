package main;

import Ejercicio01.Ejercicio01;
import Ejercicio02.Ejercicio02;
import Ejercicio03.Ejercicio03;
import Ejercicio04.Ejercicio04;
import Ejercicio05.Ejercicio05;

public class Programa {

    public static void main(String[] args) {
        int ejercicio = -1;
        do {
            ejercicio = Consola.readInteger("Selecciona un ejercicio (6 para salir): ");
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
                    break;
                default:
                    System.out.println("Ejercicio no valido!");
                    break;
            }
        } while (ejercicio != 6);
    }

}