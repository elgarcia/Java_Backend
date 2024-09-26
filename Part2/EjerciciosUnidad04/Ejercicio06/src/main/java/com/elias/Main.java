package com.elias;


import java.lang.reflect.Field;

public class Main
{
    public static void changeValue(Object objeto, String nombreCampos, Object nuevoValor) {
        if (objeto == null || nombreCampos == null || nombreCampos.isEmpty()){
            throw new IllegalArgumentException("Null or empty argument.");
        }

        try{
            Class<?>    obclass = objeto.getClass();
            Field       atrribute = obclass.getDeclaredField(nombreCampos);
            atrribute.setAccessible(true);

            if (atrribute.isAnnotationPresent(ValoresValidos.class)){
                ValoresValidos  annotation = atrribute.getAnnotation(ValoresValidos.class);
                String[]        validValues = annotation.value();

                boolean isValid = false;
                for (String validValue: validValues){
                    if (validValue.equals(nuevoValor.toString())){
                        isValid = true;
                        break;
                    }
                }

                if (!isValid){
                    throw new InvalidValueException("The value " + nuevoValor + " is not valid for " + nombreCampos
                     + " field");
                }

                atrribute.set(objeto, nuevoValor);
            }

        } catch (NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException("Couldnt change " + nombreCampos, e);
        }
    }

    public static void main( String[] args ) {
        Toy actionMan = new Toy("ActionMan", "AVAILABLE");

        try{
            changeValue(actionMan, "status", "OUT OF STOCK");
            System.out.println("New status: " + actionMan.getStatus());

            changeValue(actionMan, "status", "NON VALID");
        } catch (InvalidValueException e){
            System.err.println(e.getMessage());
        }
    }
}
