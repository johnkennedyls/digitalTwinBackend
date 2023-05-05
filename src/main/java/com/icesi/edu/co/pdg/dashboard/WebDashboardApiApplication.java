package com.icesi.edu.co.pdg.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication

@ComponentScan(basePackages = {"com.icesi.edu.co.pdg.dashboard.repositories"})
@EntityScan(basePackages = {"com.icesi.edu.co.pdg.dashboard.model.entity.*"})
@EnableJpaRepositories(basePackages = {"com.icesi.edu.co.pdg.dashboard.repositories.*"})
@Import(SpelConfiguration.class)
public class WebDashboardApiApplication {


	public static void main(String[] args) {
		SpringApplication.run(WebDashboardApiApplication.class, args);
		System.out.println("Inicia pdg");
	}

}
