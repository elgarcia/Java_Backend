package com.cloudftic.cuestion3;

import java.util.ArrayList;
import java.util.List;

public class Documento {
	private List<Parrafo> parrafos; // Aquí se almacenan los párrafos como strings.
	private String titulo;  // El título del documento.
	public Documento() {
		parrafos = new ArrayList<>();
	}

	public void agregarParrafo(int orden, String texto){
		Parrafo par = new Parrafo(orden, texto);
		this.parrafos.add(par);
	}
}
