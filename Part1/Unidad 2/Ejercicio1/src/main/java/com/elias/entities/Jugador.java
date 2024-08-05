package com.elias.entities;

import java.time.LocalDateTime;

public class Jugador {
    private String  name;
    protected int     hp;
    protected Juego   game;
    private LocalDateTime   start;
    private LocalDateTime   end;

    public Jugador(String name, int hp, Juego game) {
        this.name = name;
        this.hp = hp;
        this.game = game;
        start = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGame(Juego game) {
        this.game = game;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public Juego getGame() {
        return game;
    }

    public void finJuego(){
        end = LocalDateTime.now();
    }

    public boolean isTimeout(){
        LocalDateTime time = this.end == null ? LocalDateTime.now() : this.end;
        return (time.minusSeconds(this.game.getTime())).isAfter(this.start);
    }
}
