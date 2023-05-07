package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.icesi.edu.co.pdg.dashboard.model.dtos.AssetDTO;
import com.icesi.edu.co.pdg.dashboard.repositories.PlantRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.PlantService;

@Service
public class PlantServiceImp implements PlantService{
	PlantRepository plantRepository;

	@Override
	public List<AssetDTO> getAllPlantData() {
		return Arrays.asList(AssetDTO.getAssetListDummy());
	}
	
}
