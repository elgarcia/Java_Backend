package com.cloudftic.cuestion2;

import java.util.ArrayList;
import java.util.List;

public class Documento {
	private List<String> parrafos; // Aquí se almacenan los párrafos como strings.
	private String titulo;  // El título del documento.
	public Documento() {
		parrafos = new ArrayList<>();
	}

	public String   getParrafo(int index){
		if (index >= this.parrafos.size() || index < 0){
			return (null);
		}
		return (parrafos.get(index));
	}

	public void     setParrafo(int index, String parrafo){
		if (index >= this.parrafos.size()){
			this.parrafos.add(parrafo);
		}
		else if (this.parrafos.size() > 0){
			this.parrafos.set(index, parrafo);
		}
	}
}
