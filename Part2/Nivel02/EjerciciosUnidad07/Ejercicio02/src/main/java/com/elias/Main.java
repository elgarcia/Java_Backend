package com.elias;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		BlockingQueue<Integer>  cola = new ArrayBlockingQueue<Integer>(20);
		ExecutorService         threadExecutor = Executors.newFixedThreadPool(3);
		Future<?> hiloProductor = threadExecutor.submit(() -> {
			for(int i = 0; i < 20; i++) {
				cola.add(new Random().nextInt(100));
				try {
					Thread.sleep(300);
				} catch (InterruptedException ex) {
				}
			}
			cola.add(-1);
			cola.add(-1);
		});
		Future<?> hiloConsumidor1 = threadExecutor.submit(() -> {
			while (true) {
				try {
					if (cola.isEmpty()){
						System.out.println("Hilo consumidor 1: There are no numbers in the queue. Waiting...");
						Thread.sleep(300);
					}
					else {
						int numero = cola.take();
						if (numero == -1){
							break;
						}
						System.out.println("Hilo consumidor 1: " + numero);
					}
				} catch (InterruptedException ex) {
				}
			}
		});

		Future<?> hiloConsumidor2 = threadExecutor.submit(() -> {
			while (true) {
				try {
					if (cola.isEmpty()){
						System.out.println("Hilo consumidor 2: There are no numbers in the queue. Waiting...");
						Thread.sleep(300);
					}
					else {
						int numero = cola.take();
						if (numero == -1){
							break;
						}
						System.out.println("Hilo consumidor 2: " + numero);
					}
				} catch (InterruptedException ex) {
				}
			}
		});
		hiloProductor.get();
		threadExecutor.shutdown();
		threadExecutor.awaitTermination(1, TimeUnit.MINUTES);
	}
}