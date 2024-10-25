package com.elias;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Clob;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venta {
	@Id
	@GeneratedValue
	private int   id;
	private Clob        info;
	private LocalDate   fecha;
	private double      precio;
	private int         clienteid;
	@JoinColumn(name="CLIENTEID", referencedColumnName="ID", nullable=false)
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	private Cliente     cliente;
}
