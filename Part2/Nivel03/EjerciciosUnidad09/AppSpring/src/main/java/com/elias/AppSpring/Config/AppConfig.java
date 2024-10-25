package com.elias.AppSpring.Config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {
	@Bean
	public DataSource   dataSource(){
		return (DataSourceBuilder.create()
				.driverClassName("org.h2.Driver")
				.url("jdbc:h2:mem:my_database")
				.username("sa")
				.password("")
				.build()
				);
	}
}
