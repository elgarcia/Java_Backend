package com.elias;

class A {
    protected int metodo1() {
        return 3;
    }
}

 public class B extends A{
    public int metodo1(float d){}
}
public class Main 
{
    public static void main( String[] args ) {
        Ilambda i = x -> {x=2;};
    }
}
