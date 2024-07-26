package com.elias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Empresa extends Inquilino {
    private final String        cif;

    public Empresa(String name, String CIF){
        super(name, 0.0);
        this.cif = CIF;
    }
}
