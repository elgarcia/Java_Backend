package com.elias;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main 
{
    public static void main( String[] args ) throws Exception{
        //Server  server = Server.createWebServer().start();
        //Server.openBrowser(server.getURL());

        //System.out.println("Pulsar enter para finalizar");
        //(new java.util.Scanner(System.in)).nextLine();
        //server.stop();
        String  url = "jdbc:h2:C:/Users/DBZEL/Desktop/Uni_ciclo/FSCurso/DB/biblioteca";
        String  user = "sa";
        String  password = "";

        Connection  conexion = DriverManager.getConnection(url, user, password);
        Statement   comando = conexion.createStatement();
        String      sql1 = "SELECT autor.nombre, count(*) as cuenta\n" +
                "           FROM libro JOIN autor ON libro.autor = autor.codigo\n" +
                "           GROUP BY autor.codigo, autor.nombre\n" +
                "           HAVING cuenta = 1";
        ResultSet resultado = comando.executeQuery(sql1);
        while (resultado.next()){
            System.out.println(resultado.getString("nombre"));
            System.out.println(resultado.getInt("cuenta"));
        }
        resultado.close();
        comando.close();
        conexion.close();
    }
}
