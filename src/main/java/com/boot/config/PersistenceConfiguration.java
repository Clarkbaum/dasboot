package com.boot.config;

import org.springframework.boot.autoconfigure.flyway.FlywayDataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class PersistenceConfiguration {
	//	bean lets spring boot know the output of this function needs to be a bean (DataSource)
	@Bean
	//configprop lets them know the properties in application.properties file that starts with spring.datasource is needed for this
	@ConfigurationProperties(prefix = "spring.datasource")
	//sets the default data source if none else is specified
	@Primary
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	//2nd bean using another database
	@Bean
	@ConfigurationProperties(prefix = "datasource.flyway")
	@FlywayDataSource //flyway specifc flag
	public DataSource flywayDataSource() {
		return DataSourceBuilder.create().build();
	}

	
}
