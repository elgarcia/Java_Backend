package com.elias.Domain;

import com.elias.DTO.MedicionDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Radiacion {
    private Long    id;
    private String  latitud;
    private String  longitud;
    @JsonProperty("any")
    private Short   anho;
    private Short   radiacion;

    public Radiacion(MedicionDTO dto){
        this.id = dto.getPkMedicionID();
        this.latitud = dto.getLatitud();
        this.longitud = dto.getLongitud();
        this.anho = dto.getAnho();
        this.radiacion = dto.getRadiacion();
    }
}
