package com.icesi.edu.co.pdg.dashboard.repositories;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer>{

	
	
	
	@Override
public Optional<Plant> findById(Integer id);
	public List<Plant> findAll();
	public Plant findByPlantName(String plantName );
	
	public boolean existsByPlantName(String plantName);
}
