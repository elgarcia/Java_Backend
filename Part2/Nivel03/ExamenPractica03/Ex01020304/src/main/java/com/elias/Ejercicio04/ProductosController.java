package com.elias.Ejercicio04;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productos")
public class ProductosController {
	private ProductoRepository repo;
	public ProductosController(ProductoRepository repo) {
		this.repo = repo;
	}
	@GetMapping("/")
	public Producto getProducto(@RequestParam("nombre") String nombre) {
		return repo.findByNombre(nombre);
	}

	@GetMapping("/precio/{nombre}")
	public double getPrecio(@PathVariable String nombre){
		Producto p = repo.findByNombre(nombre);
		return (p == null ? 0.0 : p.getPrecio());
	}
}