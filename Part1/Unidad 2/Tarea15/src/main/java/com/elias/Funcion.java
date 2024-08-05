package com.elias;

import java.util.Arrays;
public abstract class Funcion {
    private String      nombre;
    protected String[]  nombreIncognitas;

    protected Funcion(String nombre, String... nombreIncognitas) {
        this.nombre = nombre;
        this.nombreIncognitas = nombreIncognitas;
    }

    public String getNombre() {
        return this.nombre + Arrays.toString(this.nombreIncognitas)
                .replace('[', '(')
                .replace(']', ')');
    }

    public String getFormula() {
        return this.getNombre() + " = " + this;
    }

    public abstract double calcular(double... x);
    public abstract String toString();
}

abstract class Funcion1Incognita extends Funcion{
    protected Funcion1Incognita(String nombre, String nombreIncognita){
        super(nombre, nombreIncognita);
    }

    @Override
    public double calcular(double... x){
        return (0);
    }
}

class Cuadrado extends Funcion1Incognita{
    private static final String NOMBRE = "Cuadrado";

    protected Cuadrado(String incognita){
        super(NOMBRE, incognita);
    }

    @Override
    public double   calcular(double... x){
        return (x[0] * x[0]);
    }

    @Override
    public String toString() {
        return (this.nombreIncognitas[0] + "^2");
    }
}

class Media extends Funcion1Incognita{
    private static final String NOMBRE = "Media";

    protected Media(String incognita){
        super(NOMBRE, incognita);
    }

    @Override
    public double   calcular(double... x){
        return (x[0] / 2);
    }

    @Override
    public String toString(){
        return (this.nombreIncognitas[0] + "/2");
    }
}

class AreaCircular extends Funcion1Incognita{
    private static final String NOMBRE = "AreaCircular";

    protected AreaCircular(String incognita){
        super(NOMBRE, incognita);
    }

    @Override
    public double calcular(double... x){
        return (Math.PI * (x[0] * x[0]));
    }
    @Override
    public String toString(){
        return ("PI * " + this.nombreIncognitas[0] + "^2");
    }
}
