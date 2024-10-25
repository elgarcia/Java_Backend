package Ejercicio01;

import lombok.Data;

@Data
public class Pelicula {
	private static final int    maxLong = 15;
	private int                 codigo;
	String                      titulo;
	Duracion                    duracion;

	public Pelicula(){
		this.codigo = (int) (Math.random() * System.currentTimeMillis());
		this.duracion = new Duracion(0, 0, 0);
		this.titulo = "";
	}

	public Pelicula(String titulo, Duracion duracion){
		this.codigo = (int) (Math.random() * System.currentTimeMillis());
		if (titulo.length() > maxLong){
			this.titulo = titulo.substring(0, maxLong) + "...";
		}
		else{
			this.titulo = titulo;
		}
		this.duracion = duracion;
	}

	public void setTitulo(String titulo) {
		if (titulo.length() > maxLong){
			this.titulo = titulo.substring(0, maxLong) + "...";
		}
		else{
			this.titulo = titulo;
		}
	}
}
