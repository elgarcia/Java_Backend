package com.elias;

public class InvalidValueException extends RuntimeException{
	public InvalidValueException(String mensaje) {
		super(mensaje);
	}
}
