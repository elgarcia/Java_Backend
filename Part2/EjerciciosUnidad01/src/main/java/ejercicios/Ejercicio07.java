package ejercicios;

import main.Consola;

public class Ejercicio07 {
	public static void main(String[] args) {
		String  contrasena;
		int     intentos = 2;

		contrasena = Consola.readText("Introduzca la contraseña: ");
		while (!contrasena.equals(args[0]) && intentos > 0){
			System.out.println("La contraseña no es correcta. Tienes " + intentos-- + " intento/s:");
			contrasena = Consola.readText("Introduzca la contraseña: ");
		}
		if (intentos == 0){
			System.out.println("Se ha superado el limite de intentos");
		}
		else{
			System.out.println("Contraseña correcta!");
		}
	}
}
