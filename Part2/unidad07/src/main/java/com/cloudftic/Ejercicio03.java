package com.cloudftic;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/*
El siguiente método debe leer dos ficheros de texto en pararelo mediante operaciones asíncronas y 
retorna la concatenación de los contenidos.

    public static Future<String> readAsync(Path ruta1, Path ruta2) {  }

Utiliza la clase CompletableFuture para retornar el objeto Future que proporcione el texto concatenado.
 */
public class Ejercicio03 {
  public static void main(String[] args) throws Exception {
    Path ruta1 = Path.of(Ejercicio03.class.getResource("../../palabras1.txt").toURI());
    Path ruta2 = Path.of(Ejercicio03.class.getResource("../../palabras2.txt").toURI());
    System.out.println(readAsync(ruta1, ruta2).get());
  }

  public static Future<String> readAsync(Path ruta1, Path ruta2) {
    var task1 = CompletableFuture.supplyAsync(() -> leerFichero(ruta1));
    var task2 = CompletableFuture.supplyAsync(() -> leerFichero(ruta2));
    return task1.thenCombineAsync(task2, (r1, r2) -> r1 + r2);

  }

  private static String leerFichero(Path ruta) {
    try {
      return Files.readString(ruta);
    } catch (IOException e) {
      return "";
    }
  }
}
