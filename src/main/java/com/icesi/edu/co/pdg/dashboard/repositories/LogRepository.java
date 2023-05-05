package com.icesi.edu.co.pdg.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.model.entity.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Integer> {

}
