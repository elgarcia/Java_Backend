package com.elias;

public class Main
{
    public static void main( String[] args ) {
        var         employees = new ListaEmpleados();
        Empleado    e1 = new Empleado("40931219C", "Eduardo", 1430);
        Empleado    e2 = new Empleado("20410983E", "Alfredo", 1800.99);
        Empleado    e3 = new Empleado("41026549D", "Ricardo", 1569.3);
        Empleado    e4 = new Empleado("49421000L", "Eric", 1900.31);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);
        employees.add(e4);

        employees.ordenaPorNombre();
        System.out.println("Orden por nombres:\n" + employees);
        employees.ordenaPorSueldo();
        System.out.println("Orden por sueldo:\n" + employees);
        System.out.println("Empleados con sueldo menor a 1600:\n" + employees.empleadosConSueldo(1600));
        System.out.println("Media de sueldos de empleados que empiezan por 'E': \n" + employees.sueldoMedioEmpiezanPor('E'));
    }
}
