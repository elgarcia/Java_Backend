package com.elias;

public class Main 
{
    public static int solicitarEdad(int edadMinima, int edadMaxima) throws EdadFueraRango {
        System.out.printf("Escribe una edad entre %d y %d:\n", edadMinima, edadMaxima);
        int edad = new java.util.Scanner(System.in).nextInt();

        if (edad < edadMinima || edad > edadMaxima){
            throw new EdadFueraRango(edad);
        }
        return (edad);
    }

    public static void main( String[] args ) {
        boolean edadValida = false;

        while (!edadValida){
            try{
                int edad = solicitarEdad(11, 25);
                System.out.println("Edad valida: " + edad);
                edadValida = true;
            } catch (EdadFueraRango e){
                System.out.println(e.getMessage());
                System.out.println("Prueba de nuevo");
            }
        }
    }
}
