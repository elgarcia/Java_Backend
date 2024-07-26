package com.elias;

public class Console {

    /**
     * Lee un texto a trav�s de teclado hasta que se pulsa la tecla Intro.
     * @param message Un mensaje que se mostrar&aacute; al principio.
     * @return El texto escrito por teclado
     */
    public static String readText(String message) {
        System.out.println(message);
        return (new java.util.Scanner(System.in)).nextLine();
    }

    /**
     * Lee un n�mero entero a trav&eacute;s de teclado hasta que se pulsa la tecla Intro.
     * @param message Un mensaje que se mostrar&aacute; al principio.
     * @return El n&uacute;mero escrito como un int.
     */
    public static int readInteger(String message) {
        System.out.println(message);
        return (new java.util.Scanner(System.in)).nextInt();
    }

    /**
     * Lee un n&uacute;mero con decimales a trav�s de teclado hasta que se pulsa
     * la tecla Intro.
     * @param message Un mensaje que se mostrar&aacute; al principio.
     * @return El n&uacute;mero escrito como un double.
     */
    public static double readReal(String message) {
        System.out.println(message);
        return (new java.util.Scanner(System.in)).nextDouble();
    }
}