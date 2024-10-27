package com.elias.Domain;

import com.elias.DTO.MedicionDTO;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "EGSMediciones")
public class MedicionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long    pk_MedicionID;

    private String  latitud;
    private String  longitud;
    private Short   anho;
    private Short   temperatura; //En grados centigrados
    private Short   viento; //En metros por segundo
    private Short   precipitacion; //en milimetros por hora

    public MedicionEntity(MedicionDTO dto){
        this.latitud = dto.getLatitud();
        this.longitud = dto.getLongitud();
        this.anho = dto.getAny();
        this.temperatura = dto.getTemperatura();
        this.viento = dto.getViento();
        this.precipitacion = dto.getPrecipitacion();
    }
}
