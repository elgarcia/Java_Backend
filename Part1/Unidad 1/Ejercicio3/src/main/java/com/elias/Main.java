package com.elias;

import java.util.Arrays;

public class Main
{
    public static int random(int minInclusive, int maxExclusive) {
        return new java.util.Random().ints(minInclusive, maxExclusive).findFirst().getAsInt();
    }

    public static int   showMenu(){
        System.out.println("MENÚ");
        System.out.println("-------------------------------");
        System.out.println("1-Cargar el array A");
        System.out.println("2-Cargar el array B");
        System.out.println("3-Mostrar el array A");
        System.out.println("4-Mostrar el array B");
        System.out.println("5-Mostrar el resultado de A+B");
        System.out.println("6-Mostrar el resultado de A*B");
        System.out.println("7-Mostrar el Array A al revés");
        System.out.println("8-Salir");
        return (Console.readInteger("Introduce una opción (1-8): "));
    }

    public static void main( String[] args ) {
        int     option;
        int[]   arrayA = null;
        int[]   arrayB = null;
        int[]   arrayC = null;
        int[]   arrayD = null;

        do{
            option = showMenu();
            switch (option)
            {
                case 1:
                    arrayA = new int[10];
                    for (int i = 0; i < arrayA.length; i++){
                        arrayA[i] = random(1, 101);
                    }
                    break;
                case 2:
                    arrayB = new int[10];
                    for (int i = 0; i < arrayB.length; i++){
                        arrayB[i] = random(1, 101);
                    }
                    break;
                case 3:
                    if (arrayA != null)
                        System.out.println(Arrays.toString(arrayA));
                    break;
                case 4:
                    if (arrayB != null)
                        System.out.println(Arrays.toString(arrayB));
                    break;
                case 5:
                    if (arrayA != null && arrayB != null)
                    {
                        arrayC = new int[10];
                        for (int i = 0; i < arrayC.length; i++){
                            arrayC[i] = arrayA[i] + arrayB[i];
                        }
                        System.out.println(Arrays.toString(arrayC));
                    }
                    break;
                case 6:
                    if (arrayA != null && arrayB != null)
                    {
                        arrayD = new int[10];
                        for (int i = 0; i < arrayD.length; i++){
                            arrayD[i] = arrayA[i] * arrayB[i];
                        }
                        System.out.println(Arrays.toString(arrayD));
                    }
                    break;
                case 7:
                    if (arrayA != null)
                    {
                        for (int i = arrayA.length - 1; i > 0; i--)
                        {
                            System.out.print(arrayA[i] + ", ");
                        }
                        System.out.println(arrayA[0]);
                    }
                    break;
                case 8:
                    System.out.println("Good bye!");
                    break;
                default:
                    System.out.println("Enter a valid option");
                    break;
            }
        } while(option != 8);
    }
}
