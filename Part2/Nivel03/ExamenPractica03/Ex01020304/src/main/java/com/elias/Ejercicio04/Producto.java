package com.elias.Ejercicio04;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Producto {
	private long id;
	private String nombre;
	private double precio;
}
