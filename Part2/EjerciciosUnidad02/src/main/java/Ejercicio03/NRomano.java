package Ejercicio03;

public class NRomano {
	private static final String[] milesimas = {"", "M", "MM", "MMM"};
	private static final String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	private static final String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	private static final String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	private int numero;
	private String  nRomano;

	public NRomano(int numero){
		if (numero < 1){
			this.numero = 1;
		}
		else if (numero > 1999) {
			this.numero = 1999;
		}
		else {
			this.numero = numero;
		}
		for (int i=0; i <= 3998; i++){
			this.nRomano = toRoman(numero);
		}
	}

	public NRomano(String nRomano){
		this.nRomano = nRomano;
		calculaNRomano();
	}

	public NRomano  add(NRomano numero){
		NRomano res = new NRomano(this.numero + numero.numero);

		return (res);
	}

	private String toRoman(int number) {
		return (milesimas[number / 1000] +
				centenas[(number % 1000) / 100] +
				decenas[(number % 100) / 10] +
				unidades[number % 10]);
	}

	public String toString(){
		return (this.nRomano);
	}
}
