package com.elias.DTO;

import lombok.Data;

@Data
public class MedicionDTO {
    private Long pkMedicionID;
    private String latitud;
    private String longitud;
    private Short any;
    private Short temperatura;
    private Short viento;
    private Short precipitacion;
    private Short radiacion;
}
