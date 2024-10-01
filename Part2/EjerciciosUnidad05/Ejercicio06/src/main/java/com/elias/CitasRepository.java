package com.elias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class CitasRepository {
	private static Map<LocalDateTime, String> citas = new TreeMap<>();

	static {
		// Datos de prueba
		citas.putAll(Map.of(LocalDateTime.of(2020,10,3,12,6), "Reunión con Felipe",
				LocalDateTime.of(2020,10,5,16,0), "Reunión de trabajo",
				LocalDateTime.of(2020,11,3,8,10), "Llevar pedido")
		);
	}

	public void add(LocalDateTime fecha, String cita) {
		// Debe añadir un nueva cita con los datos dados. Debe lanzar una excepción si ya
		// existe un cita con la fecha dada.
		if (citas.putIfAbsent(fecha, cita) != null){
			throw new RuntimeException();
		}
	}

	public void update(LocalDateTime fecha, String cita) {
		// Debe sustituir el texto de la cita en la fecha dada si existe.
		if (citas.containsKey(fecha)){
			citas.replace(fecha, cita);
		}
	}

	public List<String> consultarCitasEntre(LocalDate dia1, LocalDate dia2) {
		// Debe retornar una lista de las citas existentes entre las fechas dadas (inclusives).
		// Cada string de la lista debe comenzar por la parte de hora de la cita seguido
		//  del texto de la cita.
		return (citas.entrySet()
				.stream()
				.filter(data -> {
					LocalDate   date = data.getKey().toLocalDate();
					return ((date.isEqual(dia1) || date.isAfter(dia1)) &&
							(date.isEqual(dia2) || date.isBefore(dia2)));
				})
				.map(data -> data
							.getKey()
							.toLocalTime()
							.toString() + " " + data.getValue())
				.toList());
	}

	public Map<LocalDate, Long> contarCitasPorDia() {
		// Debe retornar un mapa donde las claves sean los días y el valor el número de citas
		// existentes en ese día. Sólo se tendrán en cuanta días para los cuales existe
		// alguna cita.
		Map<LocalDate, Long>    result = new TreeMap<>();

		citas.forEach((time, meet) -> {
			if (meet != null){
			 	result.putIfAbsent(time.toLocalDate(), citas
					    .entrySet()
					    .stream()
					    .filter(d -> d.getKey().getDayOfYear() == time.getDayOfYear())
					    .count());
			}
		});
		return (result);
	}

	public boolean existenCitasEn(LocalDate dia) {
		// Debe retornar true si existe alguna cita en el dia dado.
		return (citas.entrySet().stream().anyMatch(data -> data.getKey().toLocalDate().isEqual(dia)));
	}
	public List<String> consultarCon(BiFunction<LocalDateTime, String, Boolean> condicion) {
		// Debe retornar una lista con el texto de la citas que cumplen la condición dadad.
		// El argumento BiFunction debe recibir como argumento le fecha y el texto de la cita
		// y retornar true o false indicando si se cumple la condición o no.
	return (citas.entrySet()
				.stream()
				.filter(data -> condicion.apply(data.getKey(), data.getValue()))
				.map(data -> data.getValue())
				.toList());
	}

	@Override
	public String toString(){
		return (citas.toString());
	}
}
