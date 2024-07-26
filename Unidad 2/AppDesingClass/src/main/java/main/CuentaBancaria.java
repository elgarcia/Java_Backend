package main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/*
Un programa necesita gestionar cuentas bancarias.
Cada cuenta bancaria tendrá asignado un número de cuenta bancaria, el nombre del titular de la cuenta
y el saldo actual.

También debe estar disponible un método para abrir la cuenta con una cantidad inicial, para ingresar
dinero, para retirar dinero, y para obtener una lista de las operaciones que se han hecho en la cuenta.

Cada operación debe constar del tipo de operación ("apertura", "ingreso", "reintegro"), de la cantidad
involucrada y la fecha/hora en la que se realizó.

Utiliza una clase interna para la clase que representa las operaciones. En esta clase Operacion reescribe
el método toString() para retornar un texto como el siguiente:
     "<Titular de la cuenta>, <operación>: <cantidad>, <fecha/hora>".
 */
public class CuentaBancaria {
    private final String numero;
    private String titular;
    private double saldo = -1;
    private List<Operacion> operaciones = new ArrayList<>();

    public CuentaBancaria(String numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    private void setSaldo(double cantidad) {
            saldo += cantidad;
    }

    public void abrir(double cantidad) {
        if (saldo < 0) {
            saldo = cantidad;
            operaciones.add(this.new Operacion(TipoMovimiento.Apertura, cantidad, LocalDateTime.now()));
        } else {
            throw new RuntimeException();
        }
    }

    public void ingresar(double cantidad) {
        if (cantidad < 0)
            throw new RuntimeException();
         setSaldo(cantidad);
        operaciones.add(this.new Operacion(TipoMovimiento.Ingreso, cantidad, LocalDateTime.now()));
    }
    public void reintegrar(double cantidad) {
        if (cantidad < 0)
            throw new RuntimeException();
        setSaldo(-cantidad);
        operaciones.add(new Operacion(TipoMovimiento.Reintegro, cantidad, LocalDateTime.now()));
    }

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public class Operacion {
        private final TipoMovimiento tipo;
        private final double cantidad;
        private final LocalDateTime fecha;

        public Operacion(TipoMovimiento tipo, double cantidad, LocalDateTime fecha) {
            this.tipo = tipo;
            this.cantidad = cantidad;
            this.fecha = fecha;
        }

        @Override
        public String toString() {
            return CuentaBancaria.this.titular + ", " + tipo + ": " + cantidad + ", " + fecha;
        }
        // "<Titular de la cuenta>, <operación>: <cantidad>, <fecha/hora>".
    }
}
