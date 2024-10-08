package com.elias;

public class TareaThread extends Thread{
	public void run(){
		System.out.println("Hola mundo. Thread: " + currentThread().threadId());
	}
}
