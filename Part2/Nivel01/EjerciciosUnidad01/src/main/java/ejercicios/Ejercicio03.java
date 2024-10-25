package ejercicios;

import main.Consola;

public class Ejercicio03 {
    public static String    reverseText(String input){
        String  output = "";

        for(int i = input.length() - 1; i >= 0; i--){
            output += input.charAt(i);
        }
        return (output);
    }

    public static void main(String[] args) {
        String  input;
        String  reverse;

        input = Consola.readText("Introduce un texto: ");
        reverse = reverseText(input);
        System.out.println(reverse);
    }
}
