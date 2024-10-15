package com.elias;

import java.io.StringReader;
import java.sql.*;
import java.util.List;

public class RepositorioCompras implements IRepositorioCompras{
	final String  url = "jdbc:h2:mem:GESTION";
	final String  user = "sa";
	final String  password = "";
	private Connection  conn;

	public RepositorioCompras() throws SQLException {
		conn = DriverManager.getConnection(url, user, password);
	}

	@Override
	public void insert(int id, String info, String date, double precio, int clientid) {
		final String sql = "INSERT INTO COMPRA(ID, INFO, FECHA, PRECIO, CLIENTEID)" +
				"VALUES(?, ?, ? ,?, ?)";
		try (PreparedStatement command = this.conn.prepareStatement(sql)){
			command.setInt(1, id);
			StringReader    infocontent = new StringReader(info);
			command.setClob(2, infocontent);
			command.setDate(3, date == null ? null: Date.valueOf(date));
			command.setDouble(4, precio);
			command.setInt(5, clientid);
			command.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM COMPRA WHERE ID = ?";
		try (PreparedStatement command = this.conn.prepareStatement(sql)){
			command.setInt(1, id);
			command.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void update(int id, String date, double precio) {
		final String sql = "UPDATE COMPRA SET PRECIO = ?," +
				"FECHA = ? WHERE ID = ?";
		try (PreparedStatement command = this.conn.prepareStatement(sql)){
			command.setDouble(1, precio);
			command.setDate(2, date == null ? null : Date.valueOf(date));
			command.setInt(3, id);
			command.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<Compra> consultCompras(String date) {
		return List.of();
	}

	@Override
	public List<Cliente> consultClientes(String name) {
		return List.of();
	}
}
