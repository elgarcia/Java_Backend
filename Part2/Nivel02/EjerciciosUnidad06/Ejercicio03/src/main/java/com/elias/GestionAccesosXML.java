package com.elias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GestionAccesosXML implements GestionAccesos{
	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Acceso{
		private String  usuario;
		private String  fecha;
		private String  hora;
	}

	private final Path  file;

	public GestionAccesosXML(Path file) {
		this.file = file;
		try {
			if (Files.isRegularFile(file) && Files.size(file) == 0){
				try (XMLEncoder xml = new XMLEncoder(Files.newOutputStream(file))){
					xml.writeObject(new ArrayList<Acceso>());
				} catch (Exception exc){
					throw new RuntimeException();
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public Path getFichero() {
		return this.file;
	}

	@Override
	public void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException {
		Acceso  access = new Acceso(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString());
		try(XMLDecoder decoder = new XMLDecoder(Files.newInputStream(this.file))){
			Object obj = decoder.readObject();
			List<Acceso>    accesos = obj == null ? new ArrayList<Acceso>() : (List<Acceso>)obj;
			accesos.add(access);
			try (XMLEncoder encoder = new XMLEncoder(Files.newOutputStream(this.file))){
				encoder.writeObject(accesos);
			} catch (Exception exc){
				throw new RuntimeException();
			}
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	@Override
	public List<String> consultarUsuarios(LocalDate dia) throws IOException {
		try(XMLDecoder decoder = new XMLDecoder(Files.newInputStream(this.file))){
			Object obj = decoder.readObject();
			List<Acceso>    accesos = obj == null ? new ArrayList<Acceso>() : (List<Acceso>)obj;
			return (accesos.stream().filter(acs -> acs.fecha.equals(dia.toString()))
					.map(Acceso::getUsuario)
					.toList());
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
}
