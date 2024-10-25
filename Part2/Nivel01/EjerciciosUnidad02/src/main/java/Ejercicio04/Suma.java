package Ejercicio04;

public class Suma implements IExpresion{
	private Numero  n1;
	private Numero  n2;

	public Suma(){
		this.n1 = new Numero(0);
		this.n2 = new Numero(0);
	}

	public Suma(Numero a, Numero b){
		this.n1  = a;
		this.n2 = b;
	}

	@Override
	public Double getValor() {
		return (n1.getNumber() + n2.getNumber());
	}

	@Override
	public String getEcuacion() {
		return (this.toString() + " = " + this.getValor());
	}

	@Override
	public String toString() {
		return (n1.toString() + " + " + n2.toString());
	}
}
