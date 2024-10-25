package com.elias.Ejercicio01;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
@Entity
@Validated
public class Cliente {
	private long id;
	@NotBlank
	@Pattern(regexp = "^[A-Z].*", message = "El nombre debe empezar en mayuscula.")
	private String nombre;
	@NotEmpty(message = "La lista de pedidos no puede estar vacia.")
	private List<String> pedidos;
}
