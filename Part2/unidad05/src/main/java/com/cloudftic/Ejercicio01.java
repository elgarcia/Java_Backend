package com.cloudftic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import lombok.Data;
import lombok.NonNull;

/*
Crea una clase Empleado que permita guardar el nif, nombre y sueldo de un empleado.
Crea también una clase ListaEmpleados que herede de  ArrayList<Empleado>.
Dentro de la clase Empleado establece una ordenación natural de empleados por su nif.
Dentro de la clase ListaEmpleados crea los siguientes métodos:

    public void ordenaPorNombre()
    Debe dejar ordenada la lista de empleados por su nombre en orden alfabético ascendente.

    public void ordenaPorSueldo()
    Debe dejar ordenada la lista de empleados por su sueldo en orden ascendente.

    public Empleado getEmpleadoMayorSueldo()
    Debe retornar el primer empleado con mayor sueldo.

    public List<Empleado> empleadosConSueldo(double sueldoMaximo)
    Debe retornar los empleados con un sueldo menor o igual que el sueldo dado.

    public double sueldoMedioEmpiezanPor(char primeraLetra)
    Debe retornar el sueldo medio de aquellos empleados que comiencen por la letra indicada en el primer argumento.
 */

public class Ejercicio01 {

    public static void main(String[] args) throws Exception {
        var empleados = ListaEmpleados.create();
        empleados.addAll(
                new Random().ints(1, 100)
                        .limit(10)
                        .distinct()
                        .mapToObj(n -> Empleado.of(n + "A", "n" + n, n * 10.0))
                        .toList());

        empleados.ordenaPorNombre();
        System.out.println(empleados);
        empleados.ordenaPorSueldo();
        System.out.println(empleados);
        System.out.println(empleados.getEmpleadoMayorSueldo());
        System.out.println(empleados.empleadosConSueldo(50));
        System.out.println(empleados.sueldoMedioEmpiezanPor('n'));
    }
}

@Data(staticConstructor = "of")
class Empleado implements Comparable<Empleado> {
    private @NonNull String nif;
    private @NonNull String nombre;
    private @NonNull double sueldo;

    @Override
    public int compareTo(Empleado o) {
        return o == null ? 1 : Objects.requireNonNullElse(this.getNif(), "").compareTo(o.getNif());
    }
}

// Crea también una clase ListaEmpleados que herede de .
// Dentro de la clase Empleado establece una ordenación natural de empleados por
// su nif.
@Data(staticConstructor = "create")
class ListaEmpleados extends ArrayList<Empleado> {
    public String toString() {
        return super.toString();
    }
    public void ordenaPorNombre() {
        this.sort(Comparator.comparing(e -> e.getNombre()));
    }

    public void ordenaPorSueldo() {
        this.sort(Comparator.comparing(e -> e.getSueldo()));
    }

    public Empleado getEmpleadoMayorSueldo() {
        return Collections.max(this, Comparator.comparing(e -> e.getSueldo()));
    }

    // Debe retornar los empleados con un sueldo menor o igual que el sueldo dado.
    public List<Empleado> empleadosConSueldo(double sueldoMaximo) {
        List<Empleado> result = new ArrayList<>();
        this.forEach(e -> {
            if (e.getSueldo() <= sueldoMaximo)
                result.add(e);
        });
        return result;
    }

    // Debe retornar el sueldo medio de aquellos empleados que comiencen por la
    // letra indicada en el primer argumento.
    public double sueldoMedioEmpiezanPor(char primeraLetra) {
        double media = 0.0;
        int count = 0;
        for (Empleado e : this) {
            if (e.getNombre().charAt(0) == primeraLetra) {
                media += e.getSueldo();
                count++;
            }
        }
        return media / count;
        // return
        // this.stream().mapToDouble(Empleado::getSueldo).average().getAsDouble();
    }
}