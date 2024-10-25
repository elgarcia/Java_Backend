package com.elias;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestionAccesosCSV implements GestionAccesos{
	private final Path  file;
	private CSVFormat   format = CSVFormat.EXCEL.builder()
			.setHeader("Usuario", "Fecha", "HoraAcceso")
			.setSkipHeaderRecord(true)
			.setIgnoreEmptyLines(true)
			.build();

	public GestionAccesosCSV(Path file){
		this.file = file;
		try{
			if (Files.isRegularFile(file) && Files.size(file) == 0){
				try (CSVPrinter printer = new CSVPrinter(
						new FileWriter(this.file.getFileName().toString()), format)){
					printer.printRecord("Usuario", "Fecha", "HoraAcceso");
					printer.println();
				} catch (Exception exc){
					throw new RuntimeException();
				}
			}
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	@Override
	public Path getFichero() {
		return (this.file);
	}

	@Override
	public void insertarAcceso(String usuario, LocalDateTime acceso) throws IOException {
		try (CSVPrinter printer = new CSVPrinter(
				Files.newBufferedWriter(this.file, StandardOpenOption.APPEND), format
		)){
			printer.printRecord(usuario, acceso.toLocalDate().toString(), acceso.toLocalTime().toString());
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	@Override
	public List<String> consultarUsuarios(LocalDate dia) throws IOException {
		try (CSVParser parser = new CSVParser(
				Files.newBufferedReader(this.file), format
		)){
			return (parser.stream().
					filter(data -> data.get("Fecha").equals(dia.toString()))
					.map(data -> data.get("Usuario"))
					.toList());
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
}
