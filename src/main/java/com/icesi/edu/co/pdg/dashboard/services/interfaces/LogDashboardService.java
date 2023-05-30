package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import com.icesi.edu.co.pdg.dashboard.model.entity.LogDashboard;

public interface LogDashboardService {

	void save(String logTypeName, String description) throws Exception;

	void save(LogDashboard log) throws Exception;


}
