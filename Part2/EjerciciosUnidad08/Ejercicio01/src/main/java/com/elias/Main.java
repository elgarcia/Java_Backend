package com.elias;

import org.h2.tools.Server;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Server.createWebServer("-tcp", "-web", "-ifNotExists").start();
		var datasource = new org.h2.jdbcx.JdbcDataSource();
		datasource.setURL("jdbc:h2:mem:GESTION");
		datasource.setUser("sa");
		datasource.setPassword("");
		try (Connection  conexion = datasource.getConnection()) {
			String clientTable = "CREATE TABLE CLIENTE(" +
					"ID INTEGER PRIMARY KEY AUTO_INCREMENT," +
					"NOMBRE VARCHAR(255));";
			String compraTable = "CREATE TABLE COMPRA (" +
					"ID INTEGER PRIMARY KEY," +
					"INFO CLOB," +
					"FECHA DATE," +
					"PRECIO NUMERIC(9,3)," +
					"CLIENTEID INTEGER REFERENCES CLIENTE(ID));";
			try (Statement comando = conexion.createStatement()) {
				comando.executeUpdate(clientTable);
				comando.executeUpdate(compraTable);
			}
			Server.openBrowser("http://localhost:8082");
			System.out.println("Press enter to end connection");
			new Scanner(System.in).nextLine();
		}
		System.exit(1);
	}
}