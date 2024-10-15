package com.elias;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
	public static void main(String[] args) {
		AtomicInteger   pasosliebre = new AtomicInteger(0);
		AtomicInteger   pasostortuga = new AtomicInteger(0);
		System.out.println("Animal\tSuceso\t\tProbabilidad\tMovimiento");
		System.out.println("------\t------\t\t------------\t----------");
		var liebre = CompletableFuture.runAsync(() -> {
			while (pasosliebre.get() < 100){
					SucesoLiebre sl = SucesoLiebre.sucesoAzar();
					pasosliebre.addAndGet(sl.getPasos());
					System.out.println("Liebre\t"
							+ sl + "\t"
							+ sl.getProbabilidadDelta() + "%\t\t"
							+ (sl.getPasos() < 0 ? ((sl.getPasos() * -1) + " pasos atrás")
							: (sl.getPasos() + " pasos adelante")));
				try{
					Thread.sleep(10);
				} catch (Exception e){
					break;
				}
			}
		});
		var tortuga = CompletableFuture.runAsync(() -> {
			while (pasostortuga.get() < 100){
					SucesoTortuga st = SucesoTortuga.sucesoAzar();
					pasostortuga.addAndGet(st.getPasos());
					System.out.println("Tortuga\t"
							+ st + "\t"
							+ st.getProbabilidadDelta() + "%\t\t"
							+ (st.getPasos() < 0 ? ((st.getPasos() * -1) + " pasos atrás")
							: (st.getPasos() + " pasos adelante")));
				try{
					Thread.sleep(10);
				} catch (Exception e){
					break;
				}
			}
		});
		CompletableFuture.anyOf(liebre, tortuga).join();

		if (pasosliebre.get() == pasostortuga.get()){
			System.out.println("Empatados");
		} else {
			System.out.println("Ganador: " + (pasosliebre.get() > pasostortuga.get() ? "Liebre" : "Tortuga"));
		}
	}
}