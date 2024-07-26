package com.elias.entities;

public class Juego {
    private String  name;
    private long    time;

    public Juego(String name, long time){
        this.name = name;
        this.time = time;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

    public String getName() {
        return name;
    }
}
