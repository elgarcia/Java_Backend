package Ejercicio02;

public class Ejercicio02 {
	public static void main(String[] args) {
		DocumentBuilder d1 = new DocumentBuilder();

		d1.addParrafo("Hola buenos dias");
		d1.addParrafo("Hoy es un bonito dia");
		d1.addParrafo("Adios, buenas tardes");
		System.out.println("Numero de parrafos: " + d1.getNumeroParrafos());
		d1.terminarConPunto();
		d1.sustituyePrimero("bonito", "agradable");
		System.out.println("Sustitucion -> " + d1.getParrafo(2));
		d1.eliminarParrafo(1);
		System.out.println("Eliminar parrafo 1 -> \n" +
				"Parrafo 1: " + d1.getParrafo(1) +
				"\nParrafo 2: " + d1.getParrafo(2) +
				"\nParrafo 3: " + d1.getParrafo(3));
	}
}
