package com.elias;

import com.elias.entities.JuegoExt;
import com.elias.entities.JugadorExt;

public class Main
{
    public static void main( String[] args ) {
        JuegoExt damas = new JuegoExt("Damas", 50 * 60 + 15);
        JuegoExt majon = new JuegoExt("Majon", 15 * 60);
        JugadorExt juan = new JugadorExt("Juan", 5, damas);
        JugadorExt  marta = new JugadorExt("Marta", 4, majon);

        juan.quitaVida();
        System.out.println("Juan's hp: " + juan.getHp());

        juan.reiniciaPartida();
        System.out.println("Juan's hp: " + juan.getHp());

        juan.finJuego();
        marta.finJuego();

        System.out.println("Record " + juan.getName() + " : " + juan.actualizaRecord());
        System.out.println("Record " + marta.getName() + " : " + marta.actualizaRecord());
    }
}
