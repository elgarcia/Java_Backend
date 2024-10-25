package com.elias;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
	public static void main(String[] args) throws Exception{
		System.out.println("Executor Service");
		try (ExecutorService exs = Executors.newFixedThreadPool(3)) {
			exs.execute(new TareaRunnable());
			exs.execute(new TareaRunnable());
			exs.execute(new TareaRunnable());
		} catch (Exception e){
			throw new RuntimeException();
		}
		System.out.println("Callable");
		Callable<Object> callable1 = Executors.callable(new TareaRunnable());
		Callable<Object> callable2 = Executors.callable(new TareaRunnable());
		Callable<Object> callable3 = Executors.callable(new TareaRunnable());
		callable1.call();
		callable2.call();
		callable3.call();

		System.out.println("Normal and Runnable threads");
		for(int i = 0; i < 6; i++){
			Thread hilo;
			if (i < 3){
				hilo = new TareaThread();
			}
			else{
				hilo = new Thread(new TareaRunnable());
			}
			hilo.start();
		}
	}
}