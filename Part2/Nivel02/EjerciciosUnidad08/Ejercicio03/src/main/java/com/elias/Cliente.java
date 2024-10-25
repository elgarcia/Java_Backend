package com.elias;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Cliente {
	@Id
	@GeneratedValue
	private Integer id;
	private String  nombre;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Venta> ventas = new ArrayList<>(0);
}
