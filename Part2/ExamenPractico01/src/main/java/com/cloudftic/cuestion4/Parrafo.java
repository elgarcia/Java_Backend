package com.cloudftic.cuestion4;

public class Parrafo {
	private int     orden;
	private String  text;

	public Parrafo(int ord, String content){
		this.orden = ord;
		this.text = content;
	}

	public int  getOrden(){
		return (this.orden);
	}

	public void setText(String content){
		if (content != null && !content.isEmpty()){
			this.text = content;
		}
	}

	public String   getText(){
		return (this.text);
	}
}
