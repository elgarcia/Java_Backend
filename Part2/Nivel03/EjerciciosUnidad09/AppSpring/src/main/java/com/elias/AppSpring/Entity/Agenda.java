package com.elias.AppSpring.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Agenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String titular;
	private int anho;
	@OneToMany(mappedBy = "agenda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Anotacion> anotaciones;

	public Agenda(String titular, int anho){
		this.titular = titular;
		this.anho = anho;
	}

}
