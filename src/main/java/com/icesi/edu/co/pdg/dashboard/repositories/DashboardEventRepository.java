package com.icesi.edu.co.pdg.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.icesi.edu.co.pdg.dashboard.model.entity.EventDashboard;

public interface DashboardEventRepository extends JpaRepository<EventDashboard, Integer> {

}
