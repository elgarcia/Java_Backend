package com.elias;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MaterialCrud {
	private JdbcTemplate template;
	static RowMapper<Material> mapperMaterial = new RowMapper<Material>() {
		@Override
		public Material mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Material(
					rs.getInt("id"),
					rs.getString("nombre"),
					rs.getString("tipo")
			);
		}
	};

	public MaterialCrud(JdbcTemplate template) {
		this.template = template;
	}

	public void create(Material material) {
		try (Connection connection = this.template.getDataSource().getConnection()){
			final String sql = "INSERT INTO MATERIAL(id, nombre, tipo) VALUES (?. ?, ?)";
			this.template.update(sql, material.getId(), material.getNombre(), material.getTipo());
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	public Material read(int id) {
		try (Connection connection = this.template.getDataSource().getConnection()){
			final String sql = "SELECT * FROM MATERIAL WHERE ID = ?";
			return (this.template.queryForObject(sql, mapperMaterial, id));
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	public void update(Material material) {
		try (Connection connection = this.template.getDataSource().getConnection()){
			final String sql = "UPDATE MATERIAL SET NOMBRE = ?, TIPO = ? WHERE ID = ?";
			this.template.update(sql, material.getNombre(), material.getTipo(), material.getId());
		} catch (Exception e){
			throw new RuntimeException();
		}
	}

	public void delete(int id) {
		try (Connection connection = this.template.getDataSource().getConnection()){
			final String sql = "DELETE FROM MATERIAL WHERE ID = ?";
			this.template.update(sql, id);
		} catch (Exception e){
			throw new RuntimeException();
		}
	}
}
