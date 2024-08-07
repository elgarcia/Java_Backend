package ejercicios;

import main.Consola;

public class Ejercicio02 {
    static public void   calculaMaxEdad(String[] gente, int[] edades){
        int maxEdad = edades[0];
        int index = 0;

        System.out.println("Persona/s mayor/es:");
        for(int i = 1; i < edades.length; i++){
            if (edades[i] > maxEdad){
                maxEdad = edades[i];
                index = i;
            }
        }
        for (int i = 0; i < edades.length; i++){
            if (edades[i] ==  maxEdad){
                System.out.println("Nombre: " + gente[i]);
            }
        }
    }

    static public int   calculaMedia(int[] edades){
        int sum = 0;

        for(int i = 0; i < edades.length; i++){
            sum += edades[i];
        }
        return (sum / edades.length);
    }

    public static void main(String[] args) {
        String[]    gente = new String[10];
        int[]       edades = new int[10];
        int         mediaEdad;

        for (int i = 0; i < 10; i++) {
            gente[i] = Consola.readText("Introduce nombre: ");
            edades[i] = Consola.readInteger("Introduce edad: ");
        }
        calculaMaxEdad(gente, edades);
        mediaEdad = calculaMedia(edades);
        System.out.println("La media de edad es " + mediaEdad);
    }
}
