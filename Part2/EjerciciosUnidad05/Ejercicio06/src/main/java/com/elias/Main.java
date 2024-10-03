package com.elias;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class Main
{
    public static void main( String[] args ) {
        CitasRepository citas = new CitasRepository();

        citas.add(LocalDateTime.of(LocalDate.now(), LocalTime.now()), "Deberes");
        citas.add(LocalDateTime.of(2020, 10, 3, 14, 0), "Padel");
        System.out.println(citas);
        citas.update(LocalDateTime.of(2020, 10, 03, 12, 06), "Reunion con Alfredo");
        System.out.println(citas);
        System.out.println(citas.consultarCitasEntre(LocalDate.of(2020, 11, 01), LocalDate.of(2024, 11, 01)));
        System.out.println(citas.contarCitasPorDia().toString());
        System.out.println(citas.existenCitasEn(LocalDate.of(2020,10,03)));
        System.out.println(citas.consultarCon((date, meet) -> meet.startsWith("R")));
        
    }
}
