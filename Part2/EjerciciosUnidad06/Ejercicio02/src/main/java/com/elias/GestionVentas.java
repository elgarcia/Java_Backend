package com.elias;

import lombok.Data;

import java.io.*;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class GestionVentas {
	private final Path ficheroVentas;

	record Venta(int codigo, String nombre, double precio, LocalDate fecha){}

	private String   ventaToString(Venta v){
		return(String
				.join(","
						, String.valueOf(v.codigo), v.nombre, String.valueOf(v.precio), v.fecha.toString());
	}

	private Venta    ventaFromString(String venta){
		String[]    ventaFields = venta.split(",");
		return (new Venta(Integer.parseInt(ventaFields[0]), ventaFields[1], Double.parseDouble(ventaFields[2])
				, LocalDate.parse(ventaFields[3])));
	}

	public void agregar(int codigo, String nombre, double precio, LocalDate fecha) throws IOException {
		Venta   v = new Venta(codigo, nombre, precio, fecha);
		try (var file = new FileWriter(this.ficheroVentas.toFile(), true);
		     var buffer = new BufferedWriter(file)){
			buffer.write(ventaToString(v));
			buffer.newLine();
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	public String encontrar(int codigo) {
		try (var    file = new FileReader(this.ficheroVentas.toFile());
		     var    buffer = new BufferedReader(file)){
			String line;
			while ((line = buffer.readLine()) != null){
				if (!line.isEmpty() && ventaFromString(line).codigo == codigo){
					return (line);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return (null);
	}

	public List<String> encontrarPara(int year) {
		List<String>    ventas = new ArrayList<>();

		try (var    file = new FileReader(this.ficheroVentas.toFile());
		     var    buffer = new BufferedReader(file)){
			String line;
			while ((line = buffer.readLine()) != null){
				if (!line.isEmpty() && ventaFromString(line).fecha.getYear() == year){
					ventas.add(line);
				}
			}
		} catch (Exception e) {
			throw new RuntimeException();
		}
		return ventas;
	}
}
