package com.icesi.edu.co.pdg.dashboard;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AlarmDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagValueDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.StateAlarm;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;
import com.icesi.edu.co.pdg.dashboard.repositories.PlantRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.StateAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.TypeAlarmRepository;
import com.icesi.edu.co.pdg.dashboard.services.springexpression.Context;


@SpringBootApplication
public class WebDashboardApiApplication  {


	public static void main(String[] args) {
		SpringApplication.run(WebDashboardApiApplication.class, args);
		System.out.println("Inicia pdg");
	}

}
