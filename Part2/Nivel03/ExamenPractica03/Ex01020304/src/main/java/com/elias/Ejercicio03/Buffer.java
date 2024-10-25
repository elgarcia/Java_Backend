package com.elias.Ejercicio03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Scope("session")
public class Buffer implements Serializable {
	private long contador;
	public Buffer() {
	}
	public long getContador() {
		return contador;
	}
	public void incrementar() {
		contador++;
	}
}
