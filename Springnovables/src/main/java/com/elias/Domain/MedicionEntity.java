package com.elias.Domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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
}
