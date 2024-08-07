package ejercicios;

import java.time.LocalTime;

/*
Dada la siguiente interfaz:

public interface IFusible {
    void encender();
    void apagar();
    boolean isEncendido();
}

Se debe crear el siguiente método:

public static void conmutar(IFusible fusible, LocalTime hora) {
    // se debe encender el fusible si han pasado de las 10 de la noche,
    // y se debe apagar a partir de las 10 de la mañana.
}

Debes ejecutar el método conmutar() usando la hora actual y un objeto anonimo
de tipo IFusible que inicialmente esté encendido.
 */
public class Ejercicio04 {
    public static void main(String[] args) {
        
    }

    public static void conmutar(IFusible fusible, LocalTime hora) {

    }
    
}


interface IFusible {
    void encender();
    void apagar();
    boolean isEncendido();
}