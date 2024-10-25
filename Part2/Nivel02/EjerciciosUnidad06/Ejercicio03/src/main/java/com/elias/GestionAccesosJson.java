package com.elias;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class GestionAccesosJson implements GestionAccesos{
	private final Path  file;

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Acceso{
		private String   usuario;
		private String   fecha;
		private String   hora;
	}

	public GestionAccesosJson(Path file) {
		this.file = file;
		try{
			if (Files.isRegularFile(file) && Files.size(file) == 0) {
				ObjectMapper    mapper = new ObjectMapper();
				mapper.writeValue(this.file.toFile(), new ArrayList<Acceso>());
			}
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	@Override
	public Path getFichero() {
		return this.file;
	}

	@Override
	public void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException {
		ObjectMapper    mapper = new ObjectMapper();
		List<Acceso>    accesos = mapper.readValue(this.file.toFile(), new TypeReference<List<Acceso>>() {});
		accesos.add(new Acceso(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString()));
		mapper.writeValue(this.file.toFile(), accesos);
	}

	@Override
	public List<String> consultarUsuarios(LocalDate dia) throws IOException {
		ObjectMapper    mapper = new ObjectMapper();
		List<Acceso>    accesos = mapper.readValue(this.file.toFile(), new TypeReference<List<Acceso>>() {});

		return (accesos.stream()
				.filter(acs -> acs.fecha.equals(dia.toString()))
				.map(Acceso::getUsuario)
				.toList());
	}
}
