package Ejercicio03;

public class NRomano {
	private static final String[] milesimas = {"", "M", "MM", "MMM"};
	private static final String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	private static final String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	private static final String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	private String[] romanNumbers = new String[3998];
	private int numero;
	private String  nRomano;

	public NRomano(int numero){
		fillRnumbers();
		this.numero = numero;
		this.nRomano = this.romanNumbers[this.numero - 1];
	}

	public NRomano(String nRomano){
		fillRnumbers();
		this.nRomano = nRomano;
		this.numero = getRNumber(this.nRomano);
	}

	public NRomano  add(NRomano numero){
		NRomano res = new NRomano(this.numero + numero.numero);

		return (res);
	}

	public int  getRNumber(String roman){
		for(int i = 0; i < 3998; i++){
			if (roman.equals(this.romanNumbers[i])){
				return (i + 1);
			}
		}
		return (0);
	}

	public void fillRnumbers(){
		for(int i = 1; i <= 3998; i++){
			this.romanNumbers[i - 1] = toRoman(i);
		}
	}

	private String toRoman(int number) {
		return (milesimas[number / 1000] +
				centenas[(number % 1000) / 100] +
				decenas[(number % 100) / 10] +
				unidades[number % 10]);
	}

	public String toString(){
		return (this.numero + " = " + this.nRomano);
	}
}
