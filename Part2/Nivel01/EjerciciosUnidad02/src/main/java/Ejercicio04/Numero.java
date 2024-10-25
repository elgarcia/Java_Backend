package Ejercicio04;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Numero {
	private double  number;

	@Override
	public String toString() {
		if (Double.isNaN(this.number)){
			return ("NaN");
		}
		else if (Double.isInfinite(this.number)){
			return ("Infinite");
		}
		else {
			return (String.valueOf(this.number));
		}
	}
}
