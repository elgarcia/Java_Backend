package com.elias;

import java.lang.reflect.Field;

public class Main
{
    static class Ejemplo{
        private int id;
        private String  nombre;

        public Ejemplo(int id, String nombre){
            this.id = id;
            this.nombre = nombre;
        }
    }
    public static Object getValorCampo(Object objeto, String nombreCampo) {
        if (objeto == null || nombreCampo == null || nombreCampo.isEmpty()){
            return (null) ;
        }

        try{
            Class<?>    obclass = objeto.getClass();
            Field       attribute = obclass.getDeclaredField(nombreCampo);
            attribute.setAccessible(true);
            return (attribute.get(objeto));
        } catch (NoSuchFieldException | IllegalAccessException e){
            return (null);
        }
    }

    public static void main( String[] args ) {
        Ejemplo a = new Ejemplo(10, "Elias");
        Object  b = getValorCampo(a, "nombre");

        System.out.println(b.toString());
    }
}
