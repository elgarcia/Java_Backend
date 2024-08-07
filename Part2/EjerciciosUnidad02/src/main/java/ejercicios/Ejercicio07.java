package ejercicios;

/*
Crea un metodo "processNumber()" que obtenga un número a partir de un array.
Ese método debe recibir como parametros un array de double y la siguiente interfaz:

interface INumberFromArray {
    double getNumber(double[] numbers);
}

En el método main, define las distintas implementaciones de la interfaz con expresiones
lambda que realicen las siguientes operaciones:
         
  - Obtener el número más alto del array.
  - Obtener el número más bajo del array.
  - Obtener la media de los números del array.
*/
public class Ejercicio07 {
    public static void main(String[] args) {
        INumberFromArray nMasAlto = null;
        INumberFromArray nMasBajo = null;
        INumberFromArray nMedia = null;

        double[] numeros = {34, -12, 34, 3, 9, -23, 7, 28};
        System.out.println( processNumberr(numeros, nMasAlto));
        System.out.println( processNumberr(numeros, nMasBajo));
        System.out.println( processNumberr(numeros, nMedia));
    }

    public static double processNumberr(double[] array, INumberFromArray nda) {
        // ..... completar ....
        return 0.0;
    }
}

interface INumberFromArray {
    double getNumber(double[] numbers);
}