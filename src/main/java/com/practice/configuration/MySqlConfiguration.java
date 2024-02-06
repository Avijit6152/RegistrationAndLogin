package com.practice.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;



@Configuration
@Profile("dev")
public class MySqlConfiguration {

	public void MySqlConfig() {
		System.out.println(this.getClass().getSimpleName()+"  class profile loaded");
	}
	
	@Bean
	public HikariDataSource getDatasource() {
		String password = System.getenv("MYSQLPWD");
		String name = System.getenv("MYSQLNAME");
		String port = System.getenv("PORT_NUMBER");

		System.out.println("password :" + password);
		System.out.println("name :" + name);
		System.out.println("port :" + port);

		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:mysql://localhost:3306/authentication");
		config.setUsername("root");
		config.setPassword("root");
		config.setDriverClassName("com.mysql.cj.jdbc.Driver");
		return new HikariDataSource(config);

	}
	
	public JdbcTemplate getJdbcTemplate(HikariDataSource hikariDataSource) {
		return new JdbcTemplate(hikariDataSource); 
	}

}



