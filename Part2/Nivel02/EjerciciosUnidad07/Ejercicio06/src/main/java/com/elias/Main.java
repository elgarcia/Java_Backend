package com.elias;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {
	public static void main(String[] args) {
		CyclicBarrier               barrier = new CyclicBarrier(200);
		BlockingQueue<Integer>      cola = new ArrayBlockingQueue<Integer>(200);
		ForkJoinPool                pool = new ForkJoinPool(200);
		List<ForkJoinTask<Integer>> tasks = new ArrayList<>();

		Callable<Integer>   callable = () -> {
			int numero = new Random().nextInt();
			while (numero % 2 == 0 || numero % 7 != 0){
				numero = new Random().nextInt();
			};
			cola.add(numero);
			barrier.await();
			return (numero);
		};

		for (int i = 0; i < 200; i++){
			ForkJoinTask<Integer>    tarea = ForkJoinTask.adapt(callable);
			tasks.add(tarea);
			pool.submit(tarea);
		}

		for (ForkJoinTask<Integer> task: tasks){
			try{
				task.get();
			} catch (InterruptedException | ExecutionException e){
				e.printStackTrace();
			}
		}

		cola.forEach(numero -> {
			System.out.println("Numero generado: " + numero + ", el mayor es: " + cola
					.stream()
					.max(Integer::compare)
					.get());
		});
		pool.shutdown();
	}
}