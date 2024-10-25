package Ejercicio03;

public class Ejercicio03 {
	public static void main(String[] args) {
		NRomano n1 = new NRomano(351);
		NRomano n2 = new NRomano("MCMXCIX");
		NRomano n3 = n1.add(n2);

		System.out.println(n1.toString());
		System.out.println(n2.toString());
		System.out.println(n3.toString());
	}
}
