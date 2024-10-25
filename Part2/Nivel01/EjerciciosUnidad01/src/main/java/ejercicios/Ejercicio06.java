package ejercicios;

import main.Consola;

public class Ejercicio06 {
	public static int   cifras(int numero){
		String number = Integer.toString(numero);
		return (number.length());
	}

	public static int   reverseNumero(int numero){
		String strnumero = Integer.toString(numero);
		String reversed = "";

		for (int i = strnumero.length() - 1; i >= 0; i--){
			reversed += strnumero.charAt(i);
		}
		return (Integer.parseInt(reversed));
	}

	public static boolean esPar(int numero){
		return (numero % 2 == 0);
	}

	public static boolean esPrimo(int numero){
		if (numero > 2){
			for (int i = 2; i < numero - 1; i++){
				if (numero % i == 0){
					return (false);
				}
			}
		}
		return (true);
	}

	public static void main(String[] args) {
		int     numero;
		int     longitud;
		int     reves;
		boolean par;
		boolean primo;

		numero = Consola.readInteger("Introduce un numero: ");
		longitud = cifras(numero);
		reves = reverseNumero(numero);
		par = esPar(numero);
		primo = esPrimo(numero);
		System.out.println("Numero de cifras:  " + longitud);
		System.out.println("Numero al reves: " + reves);
		System.out.println("Es par: " + par);
		System.out.println("Es primo: " + primo);
	}
}
