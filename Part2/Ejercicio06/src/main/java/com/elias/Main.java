package com.elias;

import java.util.Random;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) {
		CyclicBarrier   barrier = new CyclicBarrier(200);
		BlockingQueue<Integer> cola = new ArrayBlockingQueue<Integer>(200);
		Callable<Integer>   callable = () -> {
			int numero = new Random().nextInt();
			while (numero % 2 == 0 && numero % 7 != 0){
				numero = new Random().nextInt();
			};
			return (numero);
		};
		for (int i = 0; i < 200; i++){
			ForkJoinTask<Integer>    tarea = ForkJoinTask.adapt(callable);
			tarea.fork();
			try {
				cola.add(tarea.get());
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
		}
	}
}