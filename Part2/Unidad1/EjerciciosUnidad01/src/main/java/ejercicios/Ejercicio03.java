package ejercicios;

import main.Consola;

/**
 * Crea un metodo para solicitar por teclado los valores para crear un
 * polinomio, y que el metodo lo retorne. El metodo debe tener un parametro
 * para indicar el grado del polinomio.
 * Añade el metodo toString() a la clase Polynomial.
 */
public class Ejercicio03 {
    public static void main(String[] args) {
        Polynomial p = readPolynomial(3);
        Consola.println("p(x) = ", p);
    }

    private static Polynomial readPolynomial(int grade) {
        throw new UnsupportedOperationException("Unimplemented method 'readPolynomial'");
    }
}
