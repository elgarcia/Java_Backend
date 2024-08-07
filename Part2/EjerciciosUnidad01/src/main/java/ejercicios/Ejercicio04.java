package ejercicios;

import main.Consola;

import java.util.Arrays;

public class Ejercicio04 {
	public static int[] fibo(int first, int second){
		int[] res = new int[second];

		res[0] = first;
		for(int i = 0; i < second; i++){
			if (i == 0){
				res[i + 1] = res[i] + 1;
			}
			else if (i + 1 < second){
				res[i + 1] = res[i] + res[i - 1];
			}
		}
		return (res);
	}
	public static void main (String[] Args){
		int[]   fi;
		int     numero;
		int     cantidad;

		numero = Consola.readInteger("Introduce un nunero: ");
		cantidad = Consola.readInteger("Introduce una cantidad: ");
		fi = fibo(numero, cantidad);
		System.out.println(Arrays.toString(fi));
	}
}
