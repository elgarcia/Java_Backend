package com.elias;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	static public DataSource dataSourceH2() {
		return DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.url("jdbc:h2:mem:my_database")
				.username("sa")
				.password("")
				.build();
	}

	public static List<Material> seleccionarMateriales(){
		var template = new JdbcTemplate(dataSourceH2());
		try (Connection connection = template.getDataSource().getConnection()){
			final String sql = "SELECT * FROM MATERIAL";
			return (template.queryForList(sql, Material.class));
		}catch (Exception e){
			throw new RuntimeException();
		}
	}
	public static void main(String[] args) {
		List<Material> materiales = seleccionarMateriales();

		List<Material> subconjunto = seleccionarMateriales()
				.stream()
				.filter(s -> s.getNombre().length() > 10)
				.filter(s -> s.getTipo().equals("plástico") || s.getTipo().equals("arcilloso"))
				.limit(10)
				.toList();

		boolean existeArcilloso = seleccionarMateriales()
				.stream()
				.anyMatch(s -> s.getTipo().equals("arcilloso"));

		Map<String, List<Material>> grupos = seleccionarMateriales()
				.stream()
				.collect(Collectors.groupingBy(Material::getTipo));
	}
}