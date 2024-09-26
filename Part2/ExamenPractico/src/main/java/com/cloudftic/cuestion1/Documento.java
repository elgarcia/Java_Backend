package com.cloudftic.cuestion1;

import java.util.ArrayList;
import java.util.List;

public class Documento {
	private List<String> parrafos; // Aquí se almacenan los párrafos como strings.
	private String titulo;  // El título del documento.
	public Documento() {
		parrafos = new ArrayList<>();
	}

	public int  numeroParrafos(){
		return (this.parrafos.size());
	}

	public void titulo(String nuevoTitulo) {
		if (nuevoTitulo != null && !nuevoTitulo.isEmpty()) {
			if (!Character.isUpperCase(nuevoTitulo.charAt(0))) {
				nuevoTitulo = nuevoTitulo.substring(0, 1).toUpperCase() + nuevoTitulo.substring(1);
			}
			this.titulo = nuevoTitulo;
		}
	}
}
