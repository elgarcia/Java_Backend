package com.elias.Entidades;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Compra {
	final private int   id;
	private String      info;
	private Date        date;
	private double      precio;
	final private int   clienteid;
}
