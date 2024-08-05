package ejercicios;

import javax.management.RuntimeErrorException;

/**
 * Esta clase modeliza un polinomio matematico del tipo:
 * <p>
 * 4·x<sup>3</sup> - 2·x + 4 (==> 4·x<sup>3</sup> + 0·x<sup>2</sup> -
 * 2·x<sup>1</sup> + 4·x<sup>0</sup>)
 * </p>
 * Se guardan los coeficientes en un array, considerando como cero un
 * coeficiente donde no
 * aparece la correspondiente potencia de la x. El grado del polinomio es la
 * máxima potencia de x.
 */
public class Polynomial {

    private static String VARIABLE = "X";
    private static String EXPONENT_OPERATOR = "^";

    private final double[] coefficient;

    private Polynomial(double... coefficient) {
        if (coefficient.length == 0) // si no hay coeficientes
            this.coefficient = new double[] { 0 };
        else
            this.coefficient = coefficient;
    }

    /**
     * 
     * @param coeficientes Los coeficientes por orden de potencia (de cero al
     *                     grado).
     *                     Si no hay coeficientes se creara el polinomio cero.
     * @return Un Polinomio.
     */
    public static Polynomial of(double... coefficient) {
        return new Polynomial(coefficient);
    }

    /**
     * Retorna el grado del polinomio (la maxima potencia de x).
     * 
     * @return
     */
    public int getGrade() {
        return this.coefficient.length - 1;
    }

    /**
     * Calcula el valor del polinomio para el valor de x dado.
     * 
     * @param x Un valor para la incognita.
     * @return El valor del polinomio.
     */
    public double calculate(double x) {
        throw new UnsupportedOperationException("Falta completar este metodo");
    }

}
