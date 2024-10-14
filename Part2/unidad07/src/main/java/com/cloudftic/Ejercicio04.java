package com.cloudftic;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinTask;
import java.util.function.Supplier;

/*
Se quiere crear un programa que calcule dos números primos (uno de 4 dígitos y otro de 5 dígitos) y que una vez
obtenidos calcule la suma de ambos. Para aprovechar la capacidad de cálculo del procesador se ha decidido obtener
cada número primo desde un hilo de ejecución diferente.

Primero ejecuta los dos hilos con ForkJoinPool de forma que se garantice que la suma final se realice sin demora
en el momento en que ambos números primos estén disponibles.
Ten en cuenta que los hilos ForkJoinTask son demonios y por tanto se destruyen en cuanto acabe el hilo principal.
Debes hacer que el hilo principal espere a que acaben los hilos.

Después haz lo mismo usando CompletableFuture.

Para obtener el numero primo puedes usar el siguiente método:

    public static long primo(int ndigits) {
        int min = (long) Math.pow(10, ndigits - 1);
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
*/

public class Ejercicio04 {
    public static void main(String[] args) throws Exception {
        conForkJoinTask();
        conCompletableFuture();
    }

    public static void conForkJoinTask() {
        var tarea1 = ForkJoinTask.adapt(() -> primo(4));
        var tarea2 = ForkJoinTask.adapt(() -> primo(5));

        System.out.println("CON FORK: " + (tarea1.fork().join() + tarea2.fork().join()));
    }

    public static void conCompletableFuture() {
        Supplier<Long> tarea1 = () -> primo(4);
        Supplier<Long> tarea2 = () -> primo(5);
        CompletableFuture.supplyAsync(tarea1).thenCombine(
                CompletableFuture.supplyAsync(tarea2),
                (primo4, primo5) -> primo4 + primo5)
                .thenAccept(resultado -> System.out.println("CON FUTURE: " + resultado))
                .join();
    }

    public static long primo(int ndigits) {
        long min = (long) Math.pow(10, ndigits - 1);
        buscaprimo: for (long primo = min; primo < min * 10; primo++) {
            if (primo == 2)
                return primo;
            if (primo < 2 || (primo & 1) == 0)
                continue buscaprimo;
            for (long divisor = 2; divisor < primo / 2; divisor++)
                if (primo % divisor == 0)
                    continue buscaprimo;
            return primo;
        }
        throw new RuntimeException("No existe el primo");
    }
}
