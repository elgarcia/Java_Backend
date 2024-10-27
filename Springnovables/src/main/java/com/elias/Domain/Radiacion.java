package com.elias.Domain;

import com.elias.DTO.MedicionDTO;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Radiacion {
    private Long    id;
    private String  latitud;
    private String  longitud;
    private Short   any;
    private Short   radiacion;

    public Radiacion(MedicionDTO dto){
        this.id = dto.getPkMedicionID();
        this.latitud = dto.getLatitud();
        this.longitud = dto.getLongitud();
        this.any = dto.getAny();
        this.radiacion = dto.getRadiacion();
    }
}
