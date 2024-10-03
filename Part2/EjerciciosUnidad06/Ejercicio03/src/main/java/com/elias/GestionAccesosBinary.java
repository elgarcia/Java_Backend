package com.elias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.XMLDecoder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestionAccesosBinary implements GestionAccesos{
	private final Path  file;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public static class Acceso implements Serializable{
		private String  usuario;
		private String  fecha;
		private String  hora;
	}

	public GestionAccesosBinary(Path file) {
		this.file = file;
		try {
			if (Files.isRegularFile(file) && Files.size(file) == 0){
				try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file.toFile()))){
					out.writeObject(new ArrayList<Acceso>());
				}
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
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.file.toFile()))){
			Object          obj = in.readObject();
			List<Acceso>    accesos = obj == null ? new ArrayList<>() : (List<Acceso>)obj;
			accesos.add(new Acceso(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString()));
			try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(this.file.toFile()))){
				out.writeObject(accesos);
			} catch (Exception exc){
				throw new RuntimeException();
			}
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	@Override
	public List<String> consultarUsuarios(LocalDate dia) throws IOException {
		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.file.toFile()))){
			Object obj = in.readObject();
			List<Acceso>    accesos = obj == null ? new ArrayList<>() : (List<Acceso>)obj;
			return (accesos.stream().filter(acs -> acs.fecha.equals(dia.toString()))
					.map(Acceso::getUsuario)
					.toList());
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
}
