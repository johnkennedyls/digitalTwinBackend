package com.icesi.edu.co.pdg.dashboard.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icesi.edu.co.pdg.dashboard.model.entity.ActionHistory;
import com.icesi.edu.co.pdg.dashboard.model.entity.TypeAlarm;


public interface ActionHistoryRepository extends JpaRepository<ActionHistory,Integer>{

	List<ActionHistory> findByAlarmAlarmId(Integer alarmid);
}
