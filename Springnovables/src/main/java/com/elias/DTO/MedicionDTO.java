package com.elias.DTO;

import com.elias.Domain.MedicionEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class MedicionDTO {
    private Long pkMedicionID;
    private String latitud;
    private String longitud;
    private Short anho;
    private Short temperatura;
    private Short viento;
    private Short precipitacion;
    private Short radiacion;  // Dato de radiación extraído del JSON

    private <T> T getValueIfNotNull(T value) {
        return Optional.ofNullable(value).orElse(null);
    }

    public MedicionDTO(MedicionEntity medicion){
        this.pkMedicionID = getValueIfNotNull(medicion.getPk_MedicionID());
        this.latitud = getValueIfNotNull(medicion.getLatitud());
        this.longitud = getValueIfNotNull(medicion.getLongitud());
        this.anho = getValueIfNotNull(medicion.getAnho());
        this.temperatura = getValueIfNotNull(medicion.getTemperatura());
        this.viento = getValueIfNotNull(medicion.getViento());
        this.precipitacion = getValueIfNotNull(medicion.getPrecipitacion());
    }
}

