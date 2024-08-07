package ejercicios;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
La clase Collections posee algunos métodos estáticos para manipular listas.
Uno de los métodos que nos proporciona es Collections.sort() Este método
recibe como parámetro una lista y una interfaz Comparator. Podemos
pasar como parámetro una expresión lambda en lugar de un Comparator. En esa
expresión lambda podemos usar el método compareTo() de la clase String.
Crea una lista de nombres y ordenala con el método Collections.sort() de las
siguientes maneras:
  - En orden inverso alfabetico.
  - Por longitud del texto en orden ascendente.
  - Por longitud del texto y a igual de longitud por orden alfabetico
    descendente.
 */
public class Ejercicio06 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
            List.of("Juan", "Ana", "Andrea", "Miguel", "Luis", "Pedro",
            "Juan", "Margarita")
        );

    
    }
}
