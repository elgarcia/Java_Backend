package com.elias;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Main {
	public static void main(String[] args) throws IOException {
		var             inputProperties = Main.class.getResourceAsStream("../../resources/configuracion.properties");
		var             properties = new Properties();
		properties.load(inputProperties);
		final String    driver = properties.getProperty("driver");
		final String    url = properties.getProperty("cadena");
		final String    user = properties.getProperty("login");
		final String    password = properties.getProperty("password");

		try (Connection connection = DriverManager.getConnection(url, user, password)) {
			Class.forName(driver);
			try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM DATOS")){
				ResultSetMetaData   metaData = resultSet.getMetaData();
				int                 numeroColumnas = metaData.getColumnCount();

				while (resultSet.next()){
					for (int i = 0; i < numeroColumnas; i ++){
						String  nombreColumna = metaData.getColumnName(i);
						Object  valor = resultSet.getObject(i);
						System.out.println(nombreColumna + " = " + valor.toString());
					}
					System.out.println();
				}
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}