package com.cloudftic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ejercicio02 {

   public static void main(String[] args) {
         var repo = new RepositorioDepartamentos();
         repo.addDepartamento("TEST1");
         System.out.println(repo);
         repo.addEmpleado("DEP", "EmpleadoTest");
         System.out.println(repo);
         System.out.println(repo.obtenerNumeroEmpleadosPorDepartamento());
   }
}

/*
 * La siguiente clase se utiliza para gestionar los departamentos de una empresa
 * y su lista de empleados. El mapa departamentos almacena el nombre de cada
 * departamento como clave, y los empleados correspondientes como valor.
 * Añade las instrucciones de cada método de forma que no se produzcan
 * excepciones al ejecutarlos.
 */

class RepositorioDepartamentos {
   private static Map<String, List<String>> departamentos = new HashMap<>();
   static {
      // Datos de prueba
      departamentos.put("Informática", new ArrayList<String>(List.of("Juan", "María")));
      departamentos.put("Finanzas", new ArrayList<>());
      departamentos.put("Comercio", null);
   }

   public void addDepartamento(String departamento) {
      // Debe añadir un nuevo departamento si aún no existe
      departamentos.putIfAbsent(departamento, null);
   }

   public void addEmpleado(String departamento, String empleado) {
      // Debe añadir un nuevo empleado al departamento dado.
      // Si aún no existe el departamento hay que añadirlo también.
      departamentos.putIfAbsent(departamento, new ArrayList<>());
      departamentos.get(departamento).add(empleado);
   }

   public Map<String, Integer> obtenerNumeroEmpleadosPorDepartamento() {
      // Debe retornar un mapa con el nombre del departamento y su número de
      // empleados.
      Map<String, Integer> mapa = new HashMap<>();
      departamentos.forEach((dept, empls) -> mapa.put(dept, empls == null ? 0 : empls.size()));
      return mapa;
   }

   @Override
   public String toString() {
       return departamentos.toString();
   }
}