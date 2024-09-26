package com.cloudftic;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
La siguiente clase se utiliza para gestionar citas.
Resuelve los métodos de consulta usando operaciones con el API Stream.
 */

public class Ejercicio06 {

    public static void main(String[] args) {
        var repo = new CitasRepository();
        repo.add(LocalDateTime.now(), "Para hoy");
        repo.update(LocalDateTime.of(2020, 10, 3, 12, 6), "xxx");
        System.out.println(repo);
        System.out.println(repo.consultarCitasEntre(LocalDate.of(2020, 10, 1), LocalDate.of(2020, 10, 4)));
        System.out.println(repo.contarCitasPorDia());
        System.out.println(repo.consultarCon( (f,c)-> c.length()>10));
    }
}

class CitasRepository {
    private static Map<LocalDateTime, String> citas = new TreeMap<>();
    static {
        // Datos de prueba
        citas.putAll(Map.of(LocalDateTime.of(2020, 10, 3, 12, 6), "Reunión con Felipe",
                LocalDateTime.of(2020, 10, 5, 16, 0), "Reunión de trabajo",
                LocalDateTime.of(2020, 11, 3, 8, 10), "Llevar pedido"));

    }

    public void add(LocalDateTime fecha, String cita) {
        // Debe añadir un nueva cita con los datos dados. Debe lanzar una excepción si
        // ya existe un cita con la fecha dada.
        if (citas.containsKey(fecha))
            throw new RuntimeException();
        citas.put(fecha, cita);
    }

    public void update(LocalDateTime fecha, String cita) {
        // Debe sustituir el texto de la cita en la fecha dada si existe.
        citas.computeIfPresent(fecha, (f, c) -> cita);
    }

    public List<String> consultarCitasEntre(LocalDate dia1, LocalDate dia2) {
        // Debe retornar una lista de las citas existentes entre las fechas dadas
        // (inclusives).
        // Cada string de la lista debe comenzar por la parte de hora de la cita seguido
        // del texto de la cita.
        var d1 = dia1.atTime(0, 0);
        var d2 = dia2.atTime(0, 0);
        return citas.entrySet().stream()
                .filter(kv -> kv.getKey().compareTo(d1) >= 0)
                .filter(kv -> kv.getKey().compareTo(d2) <= 0)
                .map(kv -> String.format("%s: %s", kv.getKey().toLocalTime(), kv.getValue()))
                .toList();
    }

    public Map<LocalDate, Long> contarCitasPorDia() {
        // Debe retornar un mapa donde las claves sean los días y el valor el número de
        // citas existentes en ese día. Sólo se tendrán en cuanta días para los cuales
        // existe
        // alguna cita.
        return citas.entrySet().stream()
                .collect(Collectors.groupingBy(kv -> kv.getKey().toLocalDate(), Collectors.counting()));
    }

    public boolean existenCitasEn(LocalDate dia) {
        // Debe retornar true si existe alguna cita en el dia dado.
        return citas.entrySet().stream()
                .anyMatch(kv -> kv.getKey().toLocalDate().equals(dia));
    }

    public List<String> consultarCon(BiFunction<LocalDateTime, String, Boolean> condicion) {
        // Debe retornar una lista con el texto de la citas que cumplen la condición
        // dada. El argumento BiFunction debe recibir como argumento le fecha y el
        // texto de la cita y retornar true o false indicando si se cumple la condición
        // o no.
        return citas.entrySet().stream()
                .filter(kv -> condicion.apply(kv.getKey(), kv.getValue()))
                .map(kv -> kv.getValue())
                .toList();
    }

    @Override
    public String toString() {
        return citas.toString();
    }
}
