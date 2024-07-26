package com.elias.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Piso {
    private int     floor;
    private int     door;
    private double  price;
}
