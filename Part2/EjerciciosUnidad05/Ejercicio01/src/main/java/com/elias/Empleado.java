package com.elias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado implements Comparable<Empleado>{
	private String  nif;
	private String  nombre;
	private double  sueldo;

	@Override
	public int compareTo(Empleado o) {
		return (this.nif.compareTo(o.nif));
	}
	@Override
	public String toString() {
		return "Empleado{" +
				"nif='" + nif + '\'' +
				", nombre='" + nombre + '\'' +
				", sueldo=" + sueldo +
				'}';
	}
}
