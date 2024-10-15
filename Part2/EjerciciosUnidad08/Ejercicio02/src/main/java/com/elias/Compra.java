package com.elias;

import java.util.Date;

public class Compra {
	final private int   id;
	private String      info;
	private Date        date;
	private double      precio;
	final private int   clienteid;

	public Compra(int id, int clienteid) {
		this.id = id;
		this.clienteid = clienteid;
	}
}
