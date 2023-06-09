package com.icesi.edu.co.pdg.dashboard.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icesi.edu.co.pdg.dashboard.model.entity.MapSvgTag;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;

public interface MapSvgTagRepository extends JpaRepository<MapSvgTag, String>{
	public void deleteByIdAsset(Integer idAsset);
	public void deleteAllByPlant(Plant plant);
}
