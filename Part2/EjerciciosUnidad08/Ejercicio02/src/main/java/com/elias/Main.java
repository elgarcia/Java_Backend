package com.elias;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;

public class Main {
	static public DataSource dataSourceH2() {
		return DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.url("jdbc:h2:mem:GESTION")
				.username("sa")
				.password("")
				.build();
	}
	public static void main(String[] args) {

	}
}