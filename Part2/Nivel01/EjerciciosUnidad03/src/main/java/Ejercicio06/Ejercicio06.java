package Ejercicio06;

public class Ejercicio06 {
	public static void main(String[] args) {
		Suma    s1 = new Suma(12, 2);
		int     resultando = s1.suma();

		try{
			System.exit(resultando);
		} catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
	}
}
