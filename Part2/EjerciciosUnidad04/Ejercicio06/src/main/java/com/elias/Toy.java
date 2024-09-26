package com.elias;


public class Toy {
	@ValoresValidos({"AVAILABLE", "OUT OF STOCK", "RESERVED"})
	private String status;

	private String name;

	public Toy(String name, String status){
		this.name = name;
		this.status = status;
	}

	public String   getStatus(){
		return (this.status);
	}

	public String getName(){
		return (this.name);
	}
}
