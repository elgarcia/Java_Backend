package main;

import java.time.LocalDateTime;

public class MainApp {
    public static void main(String[] args) {
        var cuenta = new CuentaBancaria("1111-444444", "Juan");
        cuenta.abrir(20);
        cuenta.ingresar(1000);
        cuenta.reintegrar(50);
        System.out.println(cuenta.getOperaciones());

        var p1 = new Persona("Juan", RangoEdad.Anciano);
        System.out.println(p1);

        System.out.println("Escribe uno de estos valores");
        for(var value : RangoEdad.values()) {
            System.out.println(value);
        }
        String valor = leer();
        RangoEdad rango = RangoEdad.valueOf(valor);
        System.out.println(rango);
        int resultado =  RangoEdad.Anciano.compareTo(RangoEdad.Adulto);
        RangoEdad.Anciano.getRangoEdades().max();
    }

    private static String leer() {
        return (new java.util.Scanner(System.in)).nextLine();
    }
}
