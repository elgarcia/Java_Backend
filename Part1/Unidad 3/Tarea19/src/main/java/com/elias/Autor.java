package com.elias;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Autor {
    private int             codigo;
    private String          name;
    private java.util.Date  fecha;
}
