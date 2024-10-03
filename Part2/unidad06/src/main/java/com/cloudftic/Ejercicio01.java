package com.cloudftic;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Crea los siguientes métodos:
 */

public class Ejercicio01 {

    public static void main(String[] args) throws Exception {
       
    }

    // Debe eliminar todos los ficheros dentro del directorio "dirBase" que tengan
    // la extensión dada (supondremos que no incluye el punto).
    public static void eliminar(Path dirBase, String extension) throws IOException {
        Files.list(dirBase)
                .filter(Files::isRegularFile) // .filter(path -> Files.isRegularFile(path))
                .filter(path -> path.toString().endsWith("." + extension))
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    public record FileNameExt(String name, String ext) {
    }

    private static FileNameExt getFileNameExtension(Path pathFileName) {
        String fileName = pathFileName.getFileName().toString();
        int posDotExt = fileName.toString().lastIndexOf(".");
        String name = posDotExt == -1 ? fileName : fileName.substring(0, posDotExt);
        String ext = posDotExt == -1 ? "" : fileName.substring(posDotExt);
        return new FileNameExt(name, ext);
    }

    // Debe cambiar el nombre de los ficheros incluidos dentro del directorio
    // "dirBase" (y sus subdirectorios). Al nombre de cada fichero se le concatenará
    // (antes de la extensión, si la hay) un número contando desde 1. Es decir, al
    // primer fichero encontrado se le añadirá un 1, al segundo fichero un 2, etc.
    public static void renombrar(Path dirBase) throws IOException {
        final int[] contador = { 1 };
        Files.walk(dirBase)
                .filter(Files::isRegularFile)
                .forEach(path -> {
                    var fileNameExt = getFileNameExtension(path.getFileName());
                    String fileName = fileNameExt.name() + (contador[0]++) + fileNameExt.ext();
                    try {
                        Files.move(path, Path.of(fileName));
                    } catch (IOException ex) {
                        ex.printStackTrace(System.out);
                    }
                });
    }

    // Debe copiar los ficheros del directorio "dirOrigen", que tengan una de las
    // extensiones dadas, dentro del directorio "dirDestino". Al copiar se
    // conservara el nombre y extensión de los ficheros.
    public static void copiar(Path dirOrigen, Path dirDestino, String... extensiones) throws IOException {
        final String exts = Stream.of(extensiones).collect(Collectors.joining(",", "{", "}"));
        // Casaremos los nombres usando un pathmacher que incluya las extensiones
        // alternativas
        final var matcher = FileSystems.getDefault().getPathMatcher("**." + exts);

        Files.list(dirOrigen)
                .filter(Files::isRegularFile)
                .filter(matcher::matches) // .filter(path -> matcher.matches(path))
                .forEach(path -> {
                    try {
                        Files.move(path, dirDestino.resolve(path));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
    }

    // Debe explorar los subdirectorios dentro de "dirOrigen", mover todos los
    // ficheros a "dirOrigen" y eliminar el subdirectorio. Al final el directorio
    // "dirOrigen" debe contener sólo los ficheros.
    // Si falla alguna operación en un subdirectorio y no puede eliminarse, debe
    // continuarse con el siguiente subdirectorio.
    public static void aplanar(Path dirOrigen) throws IOException {
        Files.walkFileTree(dirOrigen, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.move(file, dirOrigen.resolve(file.getFileName()));
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                try {
                    Files.delete(dir);
                } catch (Exception e) {
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

}
