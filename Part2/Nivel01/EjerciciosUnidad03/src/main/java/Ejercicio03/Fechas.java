package Ejercicio03;

public class Fechas {
	public static boolean validateDate(int año, int mes, int dia){
		if (año <= 0)
			return (false);
		else if (mes < 1 || mes > 12)
			return (false);
		else if (dia < 1 || (dia > 31 && (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)
		) || (dia > 30 && (mes == 4 || mes == 6 || mes == 9 || mes == 11) || (dia > 28 && (mes == 2))))
			return (false);
		return (true);
	}
}
