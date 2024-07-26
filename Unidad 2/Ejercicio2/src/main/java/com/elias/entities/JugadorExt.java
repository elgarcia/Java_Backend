package com.elias.entities;

public class JugadorExt extends Jugador {
    JuegoExt game;

    enum Record{
        Igualado, Batido, Menor;
    }

    private int vidasIniciales;

    public int getVidasIniciales() {
        return vidasIniciales;
    }

    public JugadorExt(String name, int hp, JuegoExt game){
        super(name, hp, game);
        this.game = game;
        vidasIniciales = hp;
    }

    public boolean quitaVida(){
        this.hp -= 1;
        return (this.hp > 0);
    }

    public void reiniciaPartida(){
        this.hp = this.vidasIniciales;
    }

    public Record actualizaRecord(){
        if (this.game.getRecord() == this.hp)
            return (Record.Igualado);
        else if (this.game.getRecord() < this.hp) {
            this.game.setRecord(this.hp);
            return (Record.Batido);
        }
        else {
            return (Record.Menor);
        }
    }
}
