package com.elias;

public interface Operaciones {
    double      getResults();
    default String      getFormula(){
        return (this + " = " + this.getResults());
    }
    double      getOperand(int index);
}
