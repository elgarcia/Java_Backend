package ejercicios;

import main.Consola;

public class Ejercicio05 {
	static final char[] abc = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
							'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
	public static void  linea(int len){
		if (len == 1){
			System.out.println(abc[0]);
		}
		else {
			for (int i = 0; i < len; i++) {
				System.out.print(abc[i]);
			}
			for (int i = len - 2; i >= 0; i--) {
				System.out.print(abc[i]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int numero;

		numero = Consola.readInteger("Introduce un numero: ");
		for (int i = 1; i < numero; i++){
			for (int j = 0; j < (numero * 2) / 2 - i; j++){
				System.out.print(" ");
			}
			linea(i);
		}
		for (int i = numero; i > 0; i--){
			for (int j = 0; j < (numero * 2) / 2 - i; j++){
				System.out.print(" ");
			}
			linea(i);
		}
	}
}
