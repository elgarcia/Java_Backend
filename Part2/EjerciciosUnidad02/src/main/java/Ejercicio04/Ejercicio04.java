package Ejercicio04;

public class Ejercicio04 {
	public static void main(String[] args) {
		Numero  a = new Numero(Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY);
		Numero  b = new Numero(10.5);
		Numero  c = new Numero(41.23);
		Numero  d = new Numero(Double.NEGATIVE_INFINITY);
		Suma    s = new Suma(b, c);
		Resta   r = new Resta(b, c);
		Producto    p = new Producto(b, c);
		Division    x = new Division(b, c);

		System.out.println("First number: " + a.toString());
		System.out.println("Second number: " + b.toString());
		System.out.println("Third number: " + c.toString());
		System.out.println("Fourth number: " + d.toString());

		System.out.println(a.toString());
		System.out.println(d.toString());

		System.out.println("Suma : " + s.getEcuacion());
		System.out.println("Resta : " + r.getEcuacion());
		System.out.println("Producto : " + p.getEcuacion());
		System.out.println("Division : " + x.getEcuacion());
	}
}
