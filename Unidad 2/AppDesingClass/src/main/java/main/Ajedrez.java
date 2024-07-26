package main;

import java.util.ArrayList;
import java.util.List;

/*
En un programa necesitamos representar los valores de piezas de ajedrez: peón, alfil, caballo, torre,
reina y rey. Las piezas pueden ser negras o blancas.

De cada tipo de pieza necesitamos saber su color y cuántas aparecen inicialmente en el tablero.

De cada pieza necesitamos obtener su nombre en minúsculas.

De cada tipo de pieza necesito obtener un objeto que contenga: su color y nombre.
 */
public class Ajedrez {
    public static void main(String[] args) {
        System.out.println(Integer.parseInt("56.87"));
       List<Pieza> blancas = new ArrayList<>();
       blancas.add(Pieza.peonBlanco);
       blancas.add(Pieza.torreBlanco);

//        int n = solicitarNumeroImpar();
//        dibujarRombo(n);
//        String linea = obtenerLinea(posicion)
    }

}

enum Pieza {
    peonBlanco("Peón", "blanco", 8),
    caballoBlanco("Alfil", "blanco", 2),
    torreBlanco("Torre", "blanco", 2),
    reinaBlanco("Dama", "blanco", 1),
    reyBlanco("Rey", "blanco", 1),
    peonNegro("Peón", "blanco", 8)
   ;
    private int numero;
    private String color;
    private String nombre;

    Pieza(String nombre, String color, int numero ) {
        this.numero = numero;
        this.color = color;
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return nombre.toLowerCase();
    }

    public DatosPieza getDatos() {
        return new DatosPieza(this.color, this.nombre);
    }

    public record DatosPieza(String color, String nombre) {}
}

enum PiezaAjedrez {peon, caballo, alfil, reina, rey}
class PiezaConColor {
    private PiezaAjedrez pieza;
    private String color;
}

