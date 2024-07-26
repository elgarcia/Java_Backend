package com.elias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public abstract class Inquilino {
    protected String    name;
    protected double    discount;
}
