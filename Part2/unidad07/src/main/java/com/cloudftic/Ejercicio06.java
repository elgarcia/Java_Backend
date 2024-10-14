package com.cloudftic;

import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.IntStream;

/*
Implementa una barrera (un objeto CyclicBarrier, donde un conjunto de N hilos deben llegar a la barrera 
y esperar a que lleguen todos los otros para que puedan  continuar su ejecución).

Crea un programa que lance 200 hilos con ForkJoinTask. Cada hilo debe obtener un número entero al azar
hasta que sea impar y múltiplo de 7 usando un bucle.
Una vez obtenido un número válido, añadelo a una lista sincronizada compartida por todos los hilos. Y
el hilo debe esperar a que todos los demas hagan lo mismo. A continuación, una vez que todos tienen su
numero, cada hilo imprimirá un mensaje con su número y el mayor número de todos los hilos.
Comprueba que todos los hilos impriman el mismo numero mayor.

 */

public class Ejercicio06 {
   public static void main(String[] args) {
      final int NUM = 200;

      final CyclicBarrier barrera = new CyclicBarrier(NUM);
      final ConcurrentLinkedDeque<Integer> listaNumeros = new ConcurrentLinkedDeque<>();

      // La tarea que van a ejecutar todos los hilos
      final Runnable tarea = () -> {
         var random = new Random();
         int n = 0;
         while (n % 2 == 0 || n % 7 != 0) { // mientras sea par o no sea multiplo de 7
            n = Math.abs(random.nextInt());
         }
         // Guardamos el numero
         listaNumeros.add(n);
         // Esperamos a que los demas hayan acabado para imprimir
         try {
            barrera.await();
         } catch (Exception e) {
         }
         System.out.printf("Hilo %4s: mi numero es %12d y el mayor es %12d\n",
               Thread.currentThread().getId(), n, listaNumeros.stream().max(Comparator.naturalOrder()).get());
      };

      // Lanzamos todos los hilos
      IntStream.range(0, NUM)
            .mapToObj(n -> ForkJoinTask.adapt(tarea))
            .forEach(task -> task.fork());

      System.console().readLine(); // Evitamos que finalice el hilo principal hasta pulsar ENTER.
   }

}
