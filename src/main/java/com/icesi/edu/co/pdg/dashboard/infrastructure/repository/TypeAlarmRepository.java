package com.icesi.edu.co.pdg.dashboard.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.infrastructure.entity.TypeAlarm;

@Repository
public interface TypeAlarmRepository extends JpaRepository<TypeAlarm, Long> {

}
