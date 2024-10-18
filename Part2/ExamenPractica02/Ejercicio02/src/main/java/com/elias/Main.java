package com.elias;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Crono   tiempo = new Crono();

		System.out.println(tiempo.getHoraActual());
		tiempo.inicia();
		Thread.sleep(110);
		System.out.println(tiempo.getHoraActual());
		Thread.sleep(300);
		tiempo.para();
		System.out.println(tiempo.getHoraActual());
	}
}