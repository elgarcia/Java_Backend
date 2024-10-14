package com.elias;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Main {
	public static Future<String> readAsync(Path ruta1, Path ruta2) {
		CompletableFuture<String>   fileString = CompletableFuture.supplyAsync(() -> {
			try {
				return (Files.readString(ruta1));
			} catch (IOException e){
				return "";
			}
		}).thenCombine(CompletableFuture.supplyAsync(() -> {
			try {
				return (Files.readString(ruta2));
			} catch (IOException e){
				return "";
			}
		}), (s1, s2) -> s1 + s2);

		return (fileString);
	}

	public static void main(String[] args) {

	}
}