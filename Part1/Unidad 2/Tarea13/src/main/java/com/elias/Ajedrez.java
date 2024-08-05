package com.elias;

import java.util.ArrayList;
import java.util.List;

public class Ajedrez {

    public static void fill(List<TipoPieza> color, boolean bw){
        if (bw)
        {
            color.add(TipoPieza.peonBlanco);
            color.add(TipoPieza.torreBlanco);
            color.add(TipoPieza.alfilBlanco);
            color.add(TipoPieza.caballoBlanco);
            color.add(TipoPieza.reinaBlanco);
            color.add(TipoPieza.reyBlanco);
        }
        else{
            color.add(TipoPieza.peonNegro);
            color.add(TipoPieza.torreNegro);
            color.add(TipoPieza.alfilNegro);
            color.add(TipoPieza.caballoNegro);
            color.add(TipoPieza.reinaNegro);
            color.add(TipoPieza.reyNegro);
        }
    }

    public static void main(String[] args){
        List<TipoPieza> blancas = new ArrayList<>();
        List<TipoPieza> negras = new ArrayList<>();

        fill(blancas, true);
        fill(negras, false);
    }
}
