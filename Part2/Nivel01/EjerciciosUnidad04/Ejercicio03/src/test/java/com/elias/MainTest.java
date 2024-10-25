package com.elias;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest 
{
    @Test
    public void testSolicitarEdad_edadValida() {
        int edadMinima = 11;
        int edadMaxima = 25;
        int edad;

        String input = "23\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        edad = Main.solicitarEdad(edadMinima, edadMaxima);
        assertEquals(23, edad);
    }

    @Test
    public void testSolicitarEdad_edadMenorAlMinimo() {
        int edadMinima = 18;
        int edadMaxima = 65;

        String input = "17\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(EdadFueraRango.class, () -> {
            Main.solicitarEdad(edadMinima, edadMaxima);
        });
    }

    @Test
    public void testSolicitarEdad_edadMayorAlMaximo() {
        int edadMinima = 18;
        int edadMaxima = 65;

        String input = "70\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        assertThrows(EdadFueraRango.class, () -> {
            Main.solicitarEdad(edadMinima, edadMaxima);
        });
    }
}
