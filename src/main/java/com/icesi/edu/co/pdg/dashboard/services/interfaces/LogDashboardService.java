package com.icesi.edu.co.pdg.dashboard.services.interfaces;

import com.icesi.edu.co.pdg.dashboard.model.entity.LogDashboard;

public interface LogDashboardService {

	void save(String logTypeName, LogDashboard log) throws Exception;

}
