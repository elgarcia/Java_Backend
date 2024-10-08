package com.elias;

public class TareaRunnable implements Runnable{
	@Override
	public void run() {
		System.out.println("Hola mundo. Thread: " + Thread.currentThread().threadId());
	}
}
