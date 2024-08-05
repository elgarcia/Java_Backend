package com.elias;

public class Main 
{
    public static void showResult(int rNumber, int pNumber){
        while (rNumber != pNumber)
        {
            System.out.println("Wrong number, Try Again! (The number was " + rNumber + ")");
            rNumber = random(1, 11);
            pNumber = Console.readInteger("Introduce new number: ");
        }
        System.out.println("You guess the right number: " + pNumber + " -> " + rNumber);
    }

    public static int random(int minInclusive, int maxExclusive) {
        return new java.util.Random().ints(minInclusive, maxExclusive).findFirst().getAsInt();
    }

    public static void main( String[] args ) {
        int randomNumber;
        int playerNumber;

        randomNumber = random(1, 11);
        playerNumber = Console.readInteger("Introduce a number between 1 and 10: ");
        showResult(randomNumber, playerNumber);
    }
}
