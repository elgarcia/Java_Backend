package Ejercicio02;

public class Ejercicio02 {
    public static void main(String[] args) {
        Vector v1 = new Vector(3, 1);
        Vector v2 = new Vector(4, 5);
        Vector v3 = v1.suma(v2);

        System.out.println(v1.toString());
        System.out.println(v2.toString());
        System.out.println(v3.toString());
    }
}

