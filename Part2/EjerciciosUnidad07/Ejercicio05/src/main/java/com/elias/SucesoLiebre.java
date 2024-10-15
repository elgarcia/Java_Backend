package com.elias;

import lombok.Getter;

import java.util.Random;

public enum SucesoLiebre {
	Duerme(20, 0), GranSalto(40, 9), ResbalonGrande(50, -12),
	PequenoSalto(80, 1), ResbaloPequeno(100, -2);
	private static Random random = new Random();
	private @Getter
	final int probabilidadDelta;
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
