package com.elias.AppSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class AppSpringApplication {
	@Autowired
	DataSource dataSource;

	public static void main(String[] args) {
		var context = SpringApplication.run(AppSpringApplication.class, args);
	}

}
