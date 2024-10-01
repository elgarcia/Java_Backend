package com.elias;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioDepartamentos {
	private static Map<String, List<String>> departamentos = new HashMap<>();
	static {
		// Datos de prueba
		departamentos.put("Informática", new ArrayList<>(List.of("Juan", "María")));
		departamentos.put("Finanzas", new ArrayList<>());
		departamentos.put("Comercio", null);
	}
	public void addDepartamento(String departamento) {
		// Debe añadir un nuevo departamento si aún no existe
		try{
			departamentos.putIfAbsent(departamento, new ArrayList<>());
		} catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
	}
	public void addEmpleado(String departamento, String empleado) {
		// Debe añadir un nuevo empleado al departamento dado.
		// Si aún no existe el departamento hay que añadirlo también.
		try{
			departamentos.putIfAbsent(departamento, new ArrayList<>());
			departamentos.get(departamento).add(empleado);
		}   catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
	}
	public Map<String, Integer> obtenerNumeroEmpleadosPorDepartamento() {
		// Debe retornar un mapa con el nombre del departamento y su número de empleados.
		Map<String, Integer>    result = new HashMap<>();
		try{
			departamentos.forEach((deps, empls) -> result.put(deps, empls == null ? 0 : empls.size()));
		}   catch (RuntimeException e){
			System.out.println(e.getMessage());
		}
		return (result);
	}

	@Override
	public String   toString(){
		return (departamentos.toString());
	}
}