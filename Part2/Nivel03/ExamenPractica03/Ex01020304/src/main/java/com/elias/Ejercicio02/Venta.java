package com.elias.Ejercicio02;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Venta {
	private int         codigo;
	private LocalDate   fecha;
	private double      precio;
}
