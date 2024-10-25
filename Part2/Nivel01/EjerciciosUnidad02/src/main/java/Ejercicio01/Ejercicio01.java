package Ejercicio01;

public class Ejercicio01 {
    public static void main(String[] args) {
        Pelicula p1 = new Pelicula("El jinete decapitado", new Duracion(1, 30, 20));
        Pelicula p2 = new Pelicula();

        p2.setDuracion(new Duracion(2, 10, 20));
        p2.setTitulo("Smurf");

        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}
