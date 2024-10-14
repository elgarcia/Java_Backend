package com.elias;

import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
	public static long primo(int ndigits) {
		long min = (long) Math.pow(10, ndigits - 1);
		buscaprimo: for (long primo = min; primo < min * 10; primo++) {
			if (primo == 2)
				return primo;
			if (primo < 2 || (primo & 1) == 0)
				continue buscaprimo;
			for (long divisor = 2; divisor < primo/2; divisor++)
				if (primo % divisor == 0)
					continue buscaprimo;
			return primo;
		}
		throw new RuntimeException("No existe el primo");
	}

	public static void main(String[] args) {
		{
			long suma;
			ForkJoinTask<Long> task1 = ForkJoinTask.adapt(() -> primo(4));
			ForkJoinTask<Long> task2 = ForkJoinTask.adapt(() -> primo(5));
			try (ForkJoinPool pool = ForkJoinPool.commonPool()) {
				pool.submit(task1);
				pool.submit(task2);
				suma = task1.get() + task2.get();
				pool.awaitTermination(5, TimeUnit.MINUTES);
			} catch (Exception e) {
				throw new RuntimeException();
			}
			System.out.println(suma);
		}
		{
			long suma;
			CompletableFuture<Long> task1 = CompletableFuture.supplyAsync(() -> primo(4));
			CompletableFuture<Long> task2 = CompletableFuture.supplyAsync(() -> primo(5));

			try {
				suma = task1.thenCombine(task2, (l1, l2) -> l1 + l2).get();
			} catch (InterruptedException | ExecutionException e) {
				throw new RuntimeException(e);
			}
			System.out.println(suma);
		}
	}
}