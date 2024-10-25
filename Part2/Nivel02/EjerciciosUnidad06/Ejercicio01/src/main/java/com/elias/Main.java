package com.elias;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main
{
    public static void eliminar(Path dirBase, String extension) {
        File        dir = new File(dirBase.toUri());
        FileFilter  filter = (File path) -> path.getName().endsWith("." + extension);
        File[]      files = dir.listFiles(filter);
        if (files != null) {
            for (File file : files) {
                try {
                    file.delete();
                } catch (SecurityException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void renombrar(Path dirBase) throws IOException {
        final AtomicInteger counter = new AtomicInteger(1);
        Files.walkFileTree(dirBase, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                String  fileName = file.getFileName().toString();
                int     dotIndex = fileName.lastIndexOf(".");
                String  newFileName = dotIndex == -1 ? (fileName + counter.getAndIncrement())
                        :   fileName.substring(0, dotIndex) + counter.getAndIncrement()
                        + fileName.substring(dotIndex);
                Files.move(file, file.getParent().resolve(newFileName));
                return FileVisitResult.CONTINUE;
            }
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                if (e == null) {
                    return FileVisitResult.CONTINUE;
                } else {
                    throw e;
                }
            }
        });
    }

    public static void copiar(Path dirOrigen, Path dirDestino, String ... extensiones) throws IOException {
        String      exts = Stream.of(extensiones).collect(Collectors.joining(",","{","}"));
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:**." + exts);
        Stream<Path>    routes = Files.walk(dirOrigen);
        routes.forEach((route) -> {
            if (matcher.matches(route)){
	            try {
		            Files.copy(route, dirDestino.resolve(route.getFileName()), StandardCopyOption.REPLACE_EXISTING);
	            } catch (IOException e) {
		            throw new RuntimeException(e);
	            }
            }
        });
    }

    public static void aplanar(Path dirOrigen) throws IOException {
        Files.walkFileTree(dirOrigen, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.move(file, dirOrigen.resolve(file.getFileName()), StandardCopyOption.ATOMIC_MOVE);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException e) throws IOException {
                try {
                    Files.delete(dir);
                } catch (Exception exc){
                }
                return FileVisitResult.CONTINUE;
            }
        });
    }

    public static void main( String[] args ) {
    }
}
