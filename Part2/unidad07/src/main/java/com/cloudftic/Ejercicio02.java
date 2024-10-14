package com.cloudftic;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
Implementa un esquema productor/consumidor. Es decir, habrá un hilo que se dedicará a crear datos y 
otros a consumirlos.

Crea un hilo productor que debe generar valores del 1 al 100 cada 300 milisegundos. Los valores deben 
ser metidos en una cola sincronizada.

Crea dos hilos consumidores. Cada uno de ellos debe sacar el primero número de la cola sincronizada 
lo antes posible e imprimirlo con un mensaje que identifique al consumidor.

Hay que optimizar el uso de los hilos para que los consumidores estén dormidos si no hay ningún valor 
en la cola sincronizada.
 */

public class Ejercicio02 {
    private final static BlockingQueue<Integer> COLA = new ArrayBlockingQueue<>(1000);

    public static void main(String[] args) throws Exception {
        var executor = Executors.newFixedThreadPool(100);

        // EL PRODUCTOR
        Callable<Void> productor = () -> {
            Random random = new Random();
            while (true) {
                try {
                    COLA.add(random.ints(1, 101).findFirst().getAsInt());
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    break;
                }
            }
            return null;
        };

        // LOS CONSUMIDORES
        Callable<Void> consumidor1 = () -> {
            while (true) {
                try {
                    int valor = COLA.take();
                    System.out.println("Consumidor 1, consume " + valor);
                } catch (InterruptedException e) {
                    break;
                }
            }
            return null;
        };

        Callable<Void> consumidor2 = () -> {
            while (true) {
                try {
                    int valor = COLA.take();
                    System.out.println("Consumidor 2, consume " + valor);
                } catch (InterruptedException e) {
                    break;
                }
            }
            return null;
        };

        List.of(productor, consumidor1, consumidor2).forEach(executor::submit);
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdownNow();
    }

}
