package com.elias;

import access.RepositorioIngresos;
import entities.Ingreso;
import org.h2.tools.Server;

import java.nio.file.Paths;


public class Main
{
    public static void main( String[] args ) throws Exception {
        RepositorioIngresos ingresos = new RepositorioIngresos(Paths.get("./Ingresos.csv"));
        ingresos.addTable();
        for (Ingreso ingreso: ingresos.getIngresos()){
            ingresos.add(ingreso);
        }

        Server              server = Server.createWebServer().start();
        Server.openBrowser(server.getURL());

        System.out.println("Press enter to continue...");
        (new java.util.Scanner(System.in)).nextLine();
        server.stop();
    }
}
