package main;

public class Persona {
    private String nombre;
    private RangoEdad rango;

    public Persona(String nombre, RangoEdad rango) {
        this.nombre = nombre;
        this.setRango(rango);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public RangoEdad getRango() {
        return rango;
    }

    public void setRango(RangoEdad rango) {
        if (rango==null)
            throw new RuntimeException();
        this.rango = rango;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", rango=" + rango +
                '}';
    }
}
