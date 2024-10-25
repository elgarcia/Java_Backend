package ejercicios;

import main.Consola;

public class Ejercicio01 {
    static final char[]  letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S',
            'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

    static public char calculaLetra(int num){
        int pos;

        pos = num % 23;
        return  (letras[pos]);
    }

    static public boolean dniCorrecto(String input){
        String[]    dni = input.split("-");
        int         i = 0;
        boolean     correct = true;
        char        letra;

        if (dni.length != 2){
            System.out.println("Formato incorrecto");
            correct = false;
        }
        if (correct && dni[0].length() != 8){
            System.out.println("Demasiados numeros");
            correct = false;
        }
        while (correct && i < 8){
            if (Character.isDigit(dni[0].charAt(i)) == false){
                System.out.println("Solo admite numeros en los primero 9 caracteres");
                correct = false;
                break;
            }
            i++;
        }
        if (dni.length == 2){
            if ((Character.isAlphabetic(dni[1].charAt(0))) == false){
                System.out.println("El ultimo caracter debe ser una letra");
                correct = false;
            }
            letra = calculaLetra(Integer.parseInt(dni[0]));
            if (letra != dni[1].charAt(0)){
                System.out.println("Letra incorrecta");
                correct = false;
            }
        }
        return (correct);
    }

    public static void main(String[] args) {

        int         i = 0;
        String      input;
        String[]    dni;

        do {
            input = Consola.readText("Introduzca su dni (12345678-A): ");
        } while (dniCorrecto(input) == false);
        System.out.println("Dni correcto!");
    }
}
