package com.icesi.edu.co.pdg.dashboard.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

public interface PlantRepository extends JpaRepository<Plant, Integer>{

}
