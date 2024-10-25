package com.elias;

import lombok.Data;

import java.io.Serializable;

@Data
public class Trabajador implements Serializable {
	private int codigo;
	private String nombre;
	transient private Trabajador ayudante; // Puede ser null u otro trabajador
}

