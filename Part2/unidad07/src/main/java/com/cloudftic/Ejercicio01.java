package com.cloudftic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/*
HILOS DE TIPO Thread

Implementa un programa que lance 12 hilos simultánemente, cada uno de los cuales debe escribir un 
"hola mundo" seguido del identificador del hilo.

Lanza 6 hilos usando objetos Thread y Runnable, y otros 6 hilos usando un ExecutorService y Callable. ¿Se nota
alguna diferencia al usar cada técnica?

 */
public class Ejercicio01 {
    public static void main(String[] args) throws InterruptedException {
        Runnable tarea = () -> System.out.println("Hola mundo, " + Thread.currentThread().getId());

        ThreadFactory tfactory = Executors.defaultThreadFactory();
        // Se lanzan 6 hilos
        IntStream.range(0, 6).forEach(
                n -> tfactory.newThread(tarea).start());

        System.out.println("_".repeat(40));

        ExecutorService exservice = Executors.newFixedThreadPool(6);
        // Se lanzan 6 hilos
        IntStream.range(0, 6).forEach(
                n -> exservice.submit(tarea));

        // Esperamos a que finalicen los hilos
        exservice.shutdown();
        exservice.awaitTermination(1, TimeUnit.DAYS);
    }

}
/*
 * No hay diferencia en la ejecución. Con ExecutorService debemos finalizar el
 * hilo
 * planificador que usa para ejecutar las tareas de su cola.
 */