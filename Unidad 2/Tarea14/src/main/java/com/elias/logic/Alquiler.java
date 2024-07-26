package com.elias.logic;

import com.elias.entities.Inquilino;
import com.elias.entities.Piso;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Alquiler {
    private Inquilino       owner;
    private Piso            build;
    private LocalDate       date;
    private static double   IVA = 0.21;

    public double  getRentPrice(){
        return (this.build.getPrice() * (1 + IVA - this.owner.getDiscount()));
    }
}
