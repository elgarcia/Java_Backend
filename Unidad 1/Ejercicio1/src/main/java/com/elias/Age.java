package com.elias;

public class Age {
    int day;
    int month;
    int year;

    public void getAge(){
        this.day = Console.readInteger("Introduce birth day: ");
        this.month = Console.readInteger("Introduce birth month: ");
        this.year = Console.readInteger("Introduce birth year: ");
    }
}
