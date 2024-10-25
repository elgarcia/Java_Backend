package Ejercicio06;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Suma {
	private int number1;
	private int number2;

	public int suma(){
		return (this.number1 + this.number2);
	}
}
