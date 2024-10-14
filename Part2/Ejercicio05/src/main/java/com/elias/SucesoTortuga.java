package com.elias;

import lombok.Getter;

import java.util.Random;

public enum SucesoTortuga {
	AvanceRapido(50, 3), Resbalo(70, -6), AvanceLento(100, 1);
	private static Random random = new Random();
	private @Getter
	final int probabilidadDelta;
	private @Getter
	final int pasos;
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
