package com.elias;

public enum TipoPieza {
    peonBlanco(8, "Blanco", "Peón"), peonNegro(8, "Negro", "Peón"),
    alfilBlanco(2, "Blanco", "Alfil"), alfilNegro(8, "Negro", "Alfil"),
    caballoBlanco(2, "Blanco", "Caballo"), caballoNegro(2, "Negro", "Caballo"),
    reinaBlanco(1, "Blanco", "Reina"), reinaNegro(1, "Negro", "Reina"),
    torreBlanco(2, "Blanco", "Torre"), torreNegro(2, "Negro", "Torre"),
    reyBlanco(1, "Blanco", "Rey"), reyNegro(1, "Negro", "Rey");
    private int     amount;
    private String  color;
    private String  name;

    TipoPieza(int amount, String color, String name){
        this.amount = amount;
        this.color = color;
        this.name = name;
    }

    public int  getAmount(){
        return (this.amount);
    }

    public String   getColor(){
        return (this.color);
    }

    @Override
    public String   toString(){
        return name.toLowerCase();
    }

    public DatosPieza getDatos(){
        return (new DatosPieza(this.color, this.name));
    }

    public record DatosPieza(String color, String nombre){}
}
