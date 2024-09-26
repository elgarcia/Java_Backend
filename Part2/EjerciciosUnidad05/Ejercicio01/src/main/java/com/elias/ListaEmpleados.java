package com.elias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListaEmpleados extends ArrayList<Empleado> {
	public void ordenaPorNombre(){
		Collections.sort(this, Comparator.comparing(empleado -> empleado.getNombre()));
	}

	public void ordenaPorSueldo(){
		Collections.sort(this, Comparator.comparing(empleado -> empleado.getSueldo()));
	}

	public Empleado getEmpleadoMayorSueldo(){
		return (Collections.max(this, Comparator.comparing(empleado -> empleado.getSueldo())));
	}

	public List<Empleado> empleadosConSueldo(double sueldoMaximo){
		List<Empleado>  result = new ArrayList<>();

		for (Empleado e: this){
			if (e.getSueldo() <= sueldoMaximo){
				result.add(e);
			}
		}
		return (result);
	}

	public double   sueldoMedioEmpiezanPor(char primeraLetra){
		List<Empleado>  empleados = new ArrayList<>();
		double          total = 0;
		int             count = 0;

		for (Empleado e: this){
			if (e.getNombre().charAt(0) == primeraLetra){
				empleados.add(e);
				total += e.getSueldo();
				count++;
			}
		}
		return (count == 0 ? 0 : total / count);
	}
}
