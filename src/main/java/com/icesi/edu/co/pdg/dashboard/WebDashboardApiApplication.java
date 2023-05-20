package com.icesi.edu.co.pdg.dashboard;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WebDashboardApiApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(WebDashboardApiApplication.class, args);
	}
}
