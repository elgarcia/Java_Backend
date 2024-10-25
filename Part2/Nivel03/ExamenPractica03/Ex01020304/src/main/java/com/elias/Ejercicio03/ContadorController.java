package com.elias.Ejercicio03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContadorController {
	private Buffer buffer;

	@Autowired
	public ContadorController(Buffer buff){
		this.buffer = buff;
	}

	@GetMapping("/contador")
	public long getContador() {
		long    count = buffer.getContador();
		buffer.incrementar();
		return count;
	}
}
