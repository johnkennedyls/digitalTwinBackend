package com.icesi.edu.co.pdg.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icesi.edu.co.pdg.dashboard.model.entity.LogTypeDashboard;

public interface LogTypeDashboardRepository extends JpaRepository<LogTypeDashboard, Integer>{

	LogTypeDashboard findByLogTypeName(String name);
}
