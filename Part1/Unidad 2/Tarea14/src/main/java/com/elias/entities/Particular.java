package com.elias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Particular extends Inquilino {
    private final String  nif;

    public Particular(String name, String NIF){
        super(name, 0.0);
        this.nif = NIF;
    }
}
