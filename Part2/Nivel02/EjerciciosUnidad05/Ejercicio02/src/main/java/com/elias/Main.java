package com.elias;

import java.util.HashMap;
import java.util.Map;

public class Main
{
    public static void main( String[] args ) {
        RepositorioDepartamentos    departamentos = new RepositorioDepartamentos();
        departamentos.addDepartamento("Recursos humanos");
        System.out.println(departamentos);
        departamentos.addEmpleado("Finanzas", "Juan");
        System.out.println(departamentos);

        Map<String, Integer>    test = new HashMap<>();
        test = departamentos.obtenerNumeroEmpleadosPorDepartamento();
        test.forEach((dep, emplds) -> System.out.println(dep + " " + emplds));
    }
}
