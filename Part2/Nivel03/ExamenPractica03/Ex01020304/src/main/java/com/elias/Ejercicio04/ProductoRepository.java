package com.elias.Ejercicio04;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
	public Producto findByNombre(String nombre);
}
