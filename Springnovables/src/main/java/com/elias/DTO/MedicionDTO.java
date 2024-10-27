package com.elias.DTO;

import com.elias.Domain.MedicionEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MedicionDTO {
    private Long pkMedicionID;
    private String latitud;
    private String longitud;
    private Short any;
    private Short temperatura;
    private Short viento;
    private Short precipitacion;
    private Short radiacion;  // Dato de radiación extraído del JSON

    public MedicionDTO(MedicionEntity medicion){
        this.pkMedicionID = medicion.getPk_MedicionID();
        this.latitud = medicion.getLatitud();
        this.longitud = medicion.getLongitud();
        this.any = medicion.getAnho();
        this.temperatura = medicion.getTemperatura();
        this.viento = medicion.getViento();
        this.precipitacion = medicion.getPrecipitacion();
    }
}

