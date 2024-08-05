package com.elias;

import access.RepositorioIngresos;
import entities.Ingreso;
import lombok.AllArgsConstructor;
import org.h2.tools.Server;

import java.io.File;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Main
{
    public static void main( String[] args ) throws Exception {
        /*RepositorioIngresos ingresos = new RepositorioIngresos(Paths.get("./Ingresos.csv"));
        ingresos.addTable();
        for (Ingreso ingreso: ingresos.getIngresos()){
            ingresos.add(ingreso);
        }

        Server              server = Server.createWebServer().start();
        Server.openBrowser(server.getURL());

        System.out.println("Press enter to continue...");
        (new java.util.Scanner(System.in)).nextLine();
        server.stop();*/
        @AllArgsConstructor
        class Clase1 {
            private static int dato1;
            private String dato2;
        }
        Clase1 a = new Clase1("2");
        ObjectOutputStream d = new ObjectOutputStream(a);
        Path z = new Path("text");
        File ruta = URI.create("file:///file.text");
    }
}
