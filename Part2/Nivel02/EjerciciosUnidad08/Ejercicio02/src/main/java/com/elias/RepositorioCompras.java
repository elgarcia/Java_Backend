package com.elias;

import com.elias.Entidades.Cliente;
import com.elias.Entidades.Compra;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.BufferedReader;
import java.io.StringReader;
import java.sql.*;
import java.util.List;
import java.util.stream.Collectors;

import static com.elias.Main.dataSourceH2;

public class RepositorioCompras implements IRepositorioCompras{
	JdbcTemplate template = new JdbcTemplate(dataSourceH2());
	RowMapper<Compra> mapperCompra = new RowMapper<Compra>() {
		@Override
		public Compra mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Compra(
					rs.getInt("ID"),
					new BufferedReader(rs.getCharacterStream("INFO"))
							.lines().collect(Collectors.joining()),
					rs.getDate("FECHA"),
					rs.getDouble("PRECIO"),
					rs.getInt("CLIENTEID")
			);
		}
	};

	static RowMapper<Cliente> mapperCliente = new RowMapper<Cliente>() {
		@Override
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Cliente(
					rs.getInt("ID"),
					rs.getString("NOMBRE")
			);
		}
	};


	@Override
	public void insert(int id, String info, String date, double precio, int clientid) {
		final String sql = "INSERT INTO COMPRA(ID, INFO, FECHA, PRECIO, CLIENTEID)" +
				"VALUES(?, ?, ? ,?, ?)";
		template.update(sql, id, new StringReader(info), Date.valueOf(date), precio, clientid);
	}

	@Override
	public void delete(int id) {
		final String sql = "DELETE FROM COMPRA WHERE ID = ?";
		template.update(sql, id);
	}

	@Override
	public void update(int id, String info, String date, double precio, int Clientid) {
		final String sql = "UPDATE COMPRA SET PRECIO = ?," +
				"FECHA = ? WHERE ID = ?";
		template.update(sql, precio, Date.valueOf(date), id);
	}

	@Override
	public List<Compra> consultCompras(String date) {
		final String sql = "SELECT ID, INFO, PRECIO, CLIENTEID" +
				"FROM COMPRA WHERE FECHA = ?";
		return template.queryForStream(sql, mapperCompra, Date.valueOf(date)).toList();
	}

	@Override
	public List<Cliente> consultClientes(String name) {
		final String sql = "SELECT ID, NOMBRE" +
				"FROM CLIENTE WHERE NOMBRE = ?";
		return template.queryForStream(sql, mapperCliente, name).toList();
	}

	public void insertaRegistrosCompra() throws SQLException {
		try (Connection conn = template.getDataSource().getConnection()){
			conn.setAutoCommit(false);
			Savepoint s1 = null;
			try{
				this.insert(1, "Info 1", "2014/1/1", 20.1, 1);
				this.insert (2, "Info 2", "2014/1/2", 20.2, 2);
				this.insert (3, "Info 3", "2014/1/3", 20.3, 1);
				this.insert (4, "Info 4", "2014/1/4", 20.4, 1);
				s1 = conn.setSavepoint();
				try{
					this.update (4, "Info 4", "2014/1/4", 10.4, 1);
				} catch (Exception e){
					System.out.println("No se ha podido actualizar el registro: " + e.getMessage());
				}
				conn.commit();
			} catch (SQLException e){
				conn.rollback(s1);
				conn.commit();
			}
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
}
