package com.elias.AppSpring.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Anotacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int dia;
	private int mes;
	private String contenido;
	@ManyToOne
	@JoinColumn(name = "agendaid")
	private Agenda agenda;

	public Anotacion(int dia, int mes, String contenido){
		this.dia = dia;
		this.mes = mes;
		this.contenido = contenido;
	}
}
