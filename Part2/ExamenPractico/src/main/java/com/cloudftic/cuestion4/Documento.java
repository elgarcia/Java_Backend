package com.cloudftic.cuestion4;

import java.util.ArrayList;
import java.util.List;

public class Documento {
	private List<Parrafo> parrafos;  // Aquí se almacenan los párrafos.
	private String titulo;    // Título del documento.
	private TipoDoc tipo;
	public Documento() {
		parrafos = new ArrayList<>();
	}

	public TipoDoc  getTipo(){
		return (this.tipo);
	}

	public void setTipo(TipoDoc type){
		this.tipo = type;
	}

	public String getTipoMay() {
		if (tipo != null) {
			return tipo.toString();
		}
		else {
			return "TIPO NO DEFINIDO";
		}
	}
}
