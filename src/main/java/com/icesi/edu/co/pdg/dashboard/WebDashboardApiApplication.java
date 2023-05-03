package com.icesi.edu.co.pdg.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan(basePackages = {"com.icesi.edu.co.pdg.dashboard.infrastructure.entity.*"})
@EnableJpaRepositories(basePackages = {"com.icesi.edu.co.pdg.dashboard.infrastructure.repository.*"})
public class WebDashboardApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebDashboardApiApplication.class, args);
		System.out.println("Inicia pdg");
	}

}
