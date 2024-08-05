package com.elias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Autor {
    private int id;
    private String nombre;
    private int numeroLibros;
}
