package com.elias;

public class EdadFueraRango extends RuntimeException{
	private int edad;

	public EdadFueraRango(int edad){
		super("Edad fuera de rango: " + edad);
		this.edad = edad;
	}

	public int  getEdad(){
		return this.edad;
	}
}
