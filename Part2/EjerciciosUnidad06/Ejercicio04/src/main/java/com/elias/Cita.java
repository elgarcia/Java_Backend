package com.elias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cita implements Serializable {
	private LocalDateTime fecha;
	private String texto;
	public void serializa(OutputStream destino) {
		try (ObjectOutputStream out = new ObjectOutputStream(destino)){
			out.writeObject(new Cita(this.fecha, this.texto.substring(0, Math.min(100, texto.length()))));
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
	public static Cita deserializa(InputStream origen) {
		try(ObjectInputStream in = new ObjectInputStream(origen)){
			Object  obj = in.readObject();
			Cita    result = (Cita)obj;
			result.setFecha(result.fecha.truncatedTo(ChronoUnit.HOURS));
			return (result);
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
}