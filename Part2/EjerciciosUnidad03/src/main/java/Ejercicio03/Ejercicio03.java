package Ejercicio03;

import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio03 {
	public static void main(String[] args) {
		System.out.println("Enter a year: ");
		int año = new Scanner(System.in).nextInt();
		System.out.println("Enter a month: ");
		int mes = new Scanner(System.in).nextInt();
		System.out.println("Enter a day: ");
		int dia = new Scanner(System.in).nextInt();

		if (Fechas.validateDate(año, mes, dia)){
			LocalDate b = LocalDate.of(año, mes, dia);
			System.out.println("Day of the week : " + b.getDayOfWeek());
			System.out.println("Is leap year? " + b.isLeapYear());
			System.out.println("Date format: " +
					b.getDayOfWeek() + " " + b.getDayOfMonth() +
					" OF " + b.getMonth() + " OF " + b.getYear());
		}
		else{
			System.out.println("Invalid date");
		}
	}
}
