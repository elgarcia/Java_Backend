package com.elias;

public class Main 
{
	public static void main( String[] args ) {
		Cuenta c1 = new Cuenta("Elias", "14151241");
		c1.open(20);
		c1.deposit(1000);
		c1.withdraw(50);
		System.out.println(c1.getOperations());
	}
}