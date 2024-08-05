package com.elias.entities;

import com.elias.entities.Juego;

public class JuegoExt extends Juego {
    private int record;

    public int getRecord() {
        return record;
    }

    public void setRecord(int record) {
        this.record = record;
    }

    public JuegoExt(String name, long time){
        super(name, time);
        this.record = 1;
    }
}
