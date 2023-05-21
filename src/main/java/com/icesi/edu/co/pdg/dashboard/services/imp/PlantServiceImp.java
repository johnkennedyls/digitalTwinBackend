package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.mappers.PlantMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.PlantRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.PlantService;

import icesi.plantapiloto.common.controllers.AssetManagerControllerPrx;
import icesi.plantapiloto.common.dtos.output.AssetDTO;

@Service
@Transactional
public class PlantServiceImp implements PlantService {

	@Autowired
	PlantRepository plantRepository;
	@Autowired
	AssetManagerControllerPrx assetManager;
	
	@Value("${webdasboard.workspace.id}")
	private Integer workspaceId;
	@Value("${webdasboard.asset.plant.id}")
	private Integer typePlantId;
	@Value("${webdasboard.asset.tag.id}")
	private Integer typeTagId;

	@Override
	public List<PlantListOutDTO> getAllPlants() {
		List<PlantListOutDTO> result = new ArrayList<>();

		List<AssetDTO> assets = Arrays.asList(assetManager.findByWorkSpace(workspaceId));
//		List<Plant> plants = plantRepository.findAll();
//		
//		Map<Integer, AssetDTO> assetMap = assets.stream().collect(Collectors.toMap(asset -> asset.assetId, asset -> asset));
//		Map<Integer, Plant> plantMap = plants.stream().collect(Collectors.toMap(Plant::getIdAsset, plant -> plant));
//		
//				
//		plantMap.forEach((id,plant) -> {
//			AssetDTO asset = assetMap.get(id);
//			PlantListOutDTO plantOut = PlantMapper.INSTANCE.plantToPlantListOutDTO(plant);
//			List<TagDTO> tags = new ArrayList<>();
//			for(AssetDTO tag: asset.childrens) {
//				TagDTO currentTag = new TagDTO();
//				currentTag.setName(tag.name);
//				currentTag.setAssetId(tag.assetId);
//				tags.add(currentTag);
//			}
//			
//			plantOut.setTags(tags);
//			result.add(plantOut);
//		});
		
		return result;
	}

	@Override
	public PlantOutDTO getByIdPlant(Integer id) throws NoResultException {
		Plant plant = plantRepository.getById(id);
		if(plant==null) {
			throw new NoResultException();
		}
		
		PlantOutDTO result = PlantMapper.INSTANCE.plantToPlantOutDTO(plant);
		return result;
	}

	@Override
	public void addPlant(PlantInDTO plant) throws BadRequestDataException {
		if(
			plant.getPlantName()==null || plant.getPlantName().isEmpty() ||
			plant.getPlantDescription() == null || plant.getPlantDescription().isEmpty() ||
			plant.getSvgImage() == null || plant.getSvgImage().isEmpty() || 
			plant.getTags() == null || plant.getTags().size() == 0 ||
			plant.getSvgs() == null || plant.getSvgs().size() == 0
		){
			throw new BadRequestDataException();
		}
		
		String name = plant.getPlantName();
		String desc = plant.getPlantDescription();
		String state = "A";
		
		Integer assetId = assetManager.saveAsset(name, desc, typePlantId, workspaceId, -1, state, null);
		
		if(assetId==-1) {
			throw new RuntimeException("Error interno, intente más tarde");
		}
		
		for(TagDTO tag : plant.getTags()) {
			assetManager.saveAsset(tag.getName(), tag.getDescription(), typeTagId, workspaceId, assetId, tag.getState().toString(), null);
		}
		
		Plant finalPlant = PlantMapper.INSTANCE.plantInDTOToPlant(plant);
		finalPlant.setIdAsset(assetId);
		plantRepository.save(finalPlant);
	}
	
	// TODO
	// Temporary meanwhile create the modification method in the AssetManager
	@Override
	public void editPlant(PlantInDTO plant, Integer plantId) throws BadRequestDataException {
		if(
			plant.getPlantName()==null || plant.getPlantName().isEmpty() ||
			plant.getPlantDescription() == null || plant.getPlantDescription().isEmpty() ||
			plant.getSvgImage() == null || plant.getSvgImage().isEmpty() || 
			plant.getTags() == null || plant.getTags().size() == 0 ||
			plant.getSvgs() == null || plant.getSvgs().size() == 0
		){
			throw new BadRequestDataException();
		}
		
		Optional<Plant> originalPlantOp = plantRepository.findById(plantId);
		if(originalPlantOp.isEmpty()) {
			throw new BadRequestDataException();
		}
		
		Plant originalPlant = originalPlantOp.get();
		
		List<AssetDTO> assets = Arrays.asList(assetManager.findByWorkSpace(workspaceId));
		Map<Integer, AssetDTO> assetMap = assets.stream().collect(Collectors.toMap(asset -> asset.assetId, asset -> asset));
		
		AssetDTO assetPlant = assetMap.get(originalPlant.getIdAsset());
		for(AssetDTO tag: assetPlant.childrens) {
			assetManager.deletById(tag.assetId);
		}
		assetManager.deletById(assetPlant.assetId);
		
		
		String name = plant.getPlantName();
		String desc = plant.getPlantDescription();
		String state = "A";		
		Integer assetId = assetManager.saveAsset(name, desc, typePlantId, workspaceId, -1, state, null);
		
		if(assetId==-1) {
			throw new RuntimeException("Error interno, intente más tarde");
		}
		
		for(TagDTO tag : plant.getTags()) {
			assetManager.saveAsset(tag.getName(), tag.getDescription(), typeTagId, workspaceId, assetId, tag.getState().toString(), null);
		}
		
		Plant finalPlant = PlantMapper.INSTANCE.plantInDTOToPlant(plant);
		finalPlant.setPlantId(plantId);
		finalPlant.setIdAsset(assetId);
		
		plantRepository.save(finalPlant);
		
		
	}

	@Override
	public void deletePlant(Integer plantId) {
		
		List<AssetDTO> assets = Arrays.asList(assetManager.findByWorkSpace(workspaceId));
		Map<Integer, AssetDTO> assetMap = assets.stream().collect(Collectors.toMap(asset -> asset.assetId, asset -> asset));
		
		AssetDTO assetPlant = assetMap.get(plantId);
		for(AssetDTO tag: assetPlant.childrens) {
			assetManager.deletById(tag.assetId);
		}
		assetManager.deletById(assetPlant.assetId);	}
}
