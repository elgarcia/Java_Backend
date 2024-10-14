package com.cloudftic;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/*
Implementa una simulación de la fábula que cuenta la carrera entre la liebre y la tortuga. Ambas tendrán que
recorrer 1000 pasos para llegar a la meta. Para hacerlo más interesante la carrera será cuesta arriba por una
pista resbaladiza, de modo que a veces podrán resbalar y retroceder algunas posiciones.

Crea un hilo que simule la carrera de la tortuga y otro hilo que simule la carrera de la liebre.

Cada hilo iterará sobre los 1000 pasos, y en cada paso suspenderá durante 10 milisegundos y luego evaluará lo que
ha pasado según unas probabilidades:


Animal 	 Suceso	         Probabilidad	Movimiento
------   --------------  ------------   -----------------
Tortuga	 Avance rápido     50%          3 pasos adelante
         Resbaló           20%          6 pasos atrás
         Avance lento      30%          1 paso adelante
Liebre   Duerme            20%          No se mueve
         Gran salto        20%          9 pasos adelante
         Resbalón grande   10%          12 pasos atrás
         Pequeño salto     30%          1 paso adelante
         Resbalón pequeño  20%          2 pasos atrás

Puedes obtener un suceso aleatorio con una enumeración como esta:

   enum SucesoTortuga {
        AvanceRapido(50, 3), Resbalo(70, -6), AvanceLento(100, 1);

        private static Random random = new Random();
        private final int probabilidadDelta;
        private @Getter final int pasos;

        private SucesoTortuga(int probabilidad, int pasos) {
            this.probabilidadDelta = probabilidad;
            this.pasos = pasos;
        }

        public static SucesoTortuga sucesoAzar() {
            int probabilidad = random.nextInt(100);
            for (var suceso : SucesoTortuga.values()) {
                if (probabilidad < suceso.probabilidadDelta)
                    return suceso;
            }
            return null;
        }
    }

    enum SucesoLiebre {
        Duerme(20, 0), GranSalto(40, 9), ResbalonGrande(50, -12),
        PequenoSalto(80, 1), ResbaloPequeno(100, -2);

        private static Random random = new Random();
        private @Getter final int probabilidadDelta;
        private @Getter final int pasos;

        private SucesoLiebre(int probabilidad, int pasos) {
            this.probabilidadDelta = probabilidad;
            this.pasos = pasos;
        }

        public static SucesoLiebre sucesoAzar() {
            int probabilidad = random.nextInt(100);
            for (var suceso : SucesoLiebre.values()) {
                if (probabilidad < suceso.probabilidadDelta)
                    return suceso;
            }
            return null;
        }
    }

Tras cada paso ve imprimiendo un mensaje para saber cómo evoluciona cada animal. Cuando un animal cubra los 1000 pasos
acabará su hilo y se le dará por ganador. En ese momento debes finalizar el otro hilo.

Si los dos llegan a la meta simultáneamente se declarará un empate.
 */

public class Ejercicio05 {

    // Los dos corredores y su estado actual
    public enum Corredor {
        Liebre, Tortuga;

        public static final int TOTALPASOS = 100;
        private @Setter @Getter boolean corriendo = true;
        private @Getter int pasosDados = 0;

        public void moverse(int pasos) {
            pasosDados += pasos;
            if (pasosDados < 0)
                pasosDados = 0;
        }

        public boolean llegaAMeta() {
            return pasosDados >= TOTALPASOS;
        }
    }

    public static void main(String[] args) throws Exception {
        final int MILISEGUNDOS = 10;

        // La carrera de la liebre. Se puede provocar su finalizacion asignando
        // corriendo=false.
        // En cuanto llegue a la meta la tarea finaliza.
        var carreraLiebre = CompletableFuture.runAsync(() -> {
            while (Corredor.Liebre.isCorriendo() && !Corredor.Liebre.llegaAMeta()) {
                var suceso = SucesoLiebre.sucesoAzar();
                Corredor.Liebre.moverse(suceso.getPasos());
                System.out.printf("%s: %s > %d\n", Corredor.Liebre, suceso ,Corredor.Liebre.getPasosDados());
                try {
                    Thread.sleep(MILISEGUNDOS);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        // La carrera de la tortuga. Se puede provocar su finalizacion asignando
        // corriendo=false.
        // En cuanto llegue a la meta la tarea finaliza.
        var carreraTortuga = CompletableFuture.runAsync(() -> {
            while (Corredor.Tortuga.isCorriendo() && !Corredor.Tortuga.llegaAMeta()) {
                var suceso = SucesoTortuga.sucesoAzar();
                Corredor.Tortuga.moverse(suceso.getPasos());
                System.out.printf("%s: %s > %d\n", Corredor.Tortuga, suceso ,Corredor.Tortuga.getPasosDados());
                try {
                    Thread.sleep(MILISEGUNDOS);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        // Planificamos las dos tareas para esperar por la que acabe antes
        CompletableFuture.anyOf(carreraLiebre, carreraTortuga).join();
        // Que dejen de correr
        Corredor.Liebre.setCorriendo(false);
        Corredor.Tortuga.setCorriendo(false);
        // Miramos el ganador
        if (Corredor.Liebre.llegaAMeta() && Corredor.Tortuga.llegaAMeta())
            System.out.println("Empatados");
        else
            System.out.println("Ganador: " + (Corredor.Liebre.llegaAMeta() ? "Liebre" : "Tortuga"));

    }

    enum SucesoTortuga {
        AvanceRapido(50, 3), Resbalo(70, -6), AvanceLento(100, 1);

        private static Random random = new Random();
        private final int probabilidadDelta;
        private @Getter final int pasos;

        private SucesoTortuga(int probabilidad, int pasos) {
            this.probabilidadDelta = probabilidad;
            this.pasos = pasos;
        }

        public static SucesoTortuga sucesoAzar() {
            int probabilidad = random.nextInt(100);
            for (var suceso : SucesoTortuga.values()) {
                if (probabilidad < suceso.probabilidadDelta)
                    return suceso;
            }
            return null;
        }
    }

    enum SucesoLiebre {
        Duerme(20, 0), GranSalto(40, 9), ResbalonGrande(50, -12),
        PequenoSalto(80, 1), ResbaloPequeno(100, -2);

        private static Random random = new Random();
        private @Getter final int probabilidadDelta;
        private @Getter final int pasos;

        private SucesoLiebre(int probabilidad, int pasos) {
            this.probabilidadDelta = probabilidad;
            this.pasos = pasos;
        }

        public static SucesoLiebre sucesoAzar() {
            int probabilidad = random.nextInt(100);
            for (var suceso : SucesoLiebre.values()) {
                if (probabilidad < suceso.probabilidadDelta)
                    return suceso;
            }
            return null;
        }
    }
}
