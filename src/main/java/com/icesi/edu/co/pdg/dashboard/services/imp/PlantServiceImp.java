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
import com.icesi.edu.co.pdg.dashboard.model.dtos.MapSvgTagDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.MapSvgTag;
import com.icesi.edu.co.pdg.dashboard.model.mappers.PlantMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.MapSvgTagRepository;
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
	MapSvgTagRepository mapRepository;
	@Autowired
	AssetManagerControllerPrx assetManager;
	
	@Value("${webdasboard.workspace.id}")
	private Integer workspaceId;
	@Value("${webdasboard.asset.plant.id}")
	private Integer typePlantId;
	@Value("${webdasboard.asset.tag.id}")
	private Integer typeTagId;
	@Value("${webdasboard.asset.tag.name}")
	private String typeTagName;
	
	@Override
	public List<PlantListOutDTO> getAllPlants() {
		List<PlantListOutDTO> result = new ArrayList<>();
		
		List<AssetDTO> assets = Arrays.asList(assetManager.findByWorkSpace(workspaceId));
		List<Plant> plants = plantRepository.findAll();
		
		for(AssetDTO asset: assets) {
			if(asset.typeName==typeTagName || asset.state.equals("R")) {
				assets.remove(asset);
			}
		}
		
		if(assets.size()==0) {
			return result;
		}
		
		Map<Integer, AssetDTO> assetMap = assets.stream().collect(Collectors.toMap(asset -> asset.assetId, asset -> asset));
		Map<Integer, Plant> plantMap = plants.stream().collect(Collectors.toMap(Plant::getAssetId, plant -> plant));
				
		plantMap.forEach((id,plant) -> {
			AssetDTO asset = assetMap.get(id);
			System.out.println(asset.name);
			PlantListOutDTO plantOut = PlantMapper.INSTANCE.plantToPlantListOutDTO(plant);
			List<TagDTO> tags = new ArrayList<>();
			for(AssetDTO tag: asset.childrens) {
				TagDTO currentTag = new TagDTO();
				currentTag.setName(tag.name);
				currentTag.setAssetId(tag.assetId);
				currentTag.setState(tag.state.charAt(0));
				tags.add(currentTag);
			}
			
			plantOut.setTags(tags);
			result.add(plantOut);
		});
		
		return result;
	}

	@Override
	public PlantOutDTO getPlantById(Integer id) throws NoResultException {
		Optional<Plant> plant = plantRepository.findById(id);
		if(plant.isEmpty()) {
			throw new NoResultException();
		}
		Plant originalPlant = plant.get();
		
		List<AssetDTO> assets = Arrays.asList(assetManager.findByWorkSpace(workspaceId));
		Map<Integer, AssetDTO> assetMap = assets.stream().collect(Collectors.toMap(asset -> asset.assetId, asset -> asset));
		AssetDTO assetPlant = assetMap.get(originalPlant.getAssetId());
		
		PlantOutDTO result = new PlantOutDTO();
		
		result.setPlantName(originalPlant.getPlantName());
		result.setPlantPhoto(originalPlant.getPlantPhoto());
		result.setPlantDescription(originalPlant.getPlantDescription());
		result.setConventions(originalPlant.getConventions());
		result.setSvgImage(originalPlant.getSvgImage());
		List<TagDTO> tags = new ArrayList<>();
		for(AssetDTO tag : assetPlant.childrens) {
			TagDTO currentTag = new TagDTO();
			if(tag.state.equals("R")) {
				continue;
			}
			currentTag.setAssetId(tag.assetId);
			currentTag.setName(tag.name);
			currentTag.setState(tag.state.charAt(0));
			tags.add(currentTag);
		}
		List<MapSvgTagDTO> svgs = new ArrayList<>();
		for(MapSvgTag svg :originalPlant.getSvgs()) {
			MapSvgTagDTO currentSvg = new MapSvgTagDTO();
			currentSvg.setSvgId(svg.getIdSvg());
			currentSvg.setIdAsset(svg.getIdAsset());
			currentSvg.setTagName(svg.getTagName());
			svgs.add(currentSvg);
		}
		result.setMapSvgTag(svgs);
		result.setTags(tags);
		return result;
	}

	@Override
	public void addPlant(PlantInDTO plant) throws BadRequestDataException {
		System.out.println(plant.getMapSvgTag().size());
		if(
			plant.getPlantName()==null || plant.getPlantName().isEmpty() ||
			plant.getPlantDescription() == null || plant.getPlantDescription().isEmpty() ||
			plant.getSvgImage() == null || plant.getSvgImage().isEmpty() || 
			plant.getTags() == null || plant.getTags().size() == 0 ||
			plant.getMapSvgTag() == null || plant.getMapSvgTag().size() == 0
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
		
		Plant finalPlant = PlantMapper.INSTANCE.plantInDTOToPlant(plant);
		finalPlant.setAssetId(assetId);
		finalPlant = plantRepository.save(finalPlant);
		
		List<MapSvgTagDTO> preSvgs = plant.getMapSvgTag();
		List<MapSvgTag> svgs = new ArrayList<>();
		for(TagDTO tag : plant.getTags()) {
			Integer tagId = assetManager.saveAsset(tag.getName(), tag.getDescription(), typeTagId, workspaceId, assetId, state, null);
			List<MapSvgTagDTO> toBeRemoved = new ArrayList<>();
			for(MapSvgTagDTO preSvg : preSvgs) {
				MapSvgTag svg = new MapSvgTag();
				if(preSvg.getTagName().equals(tag.getName())) {
					svg.setIdAsset(tagId);
					svg.setIdSvg(preSvg.getSvgId());
					svg.setTagName(tag.getName());
					svg.setPlant(finalPlant);
					svgs.add(svg);
					toBeRemoved.add(preSvg);
				}
			}
			preSvgs.removeAll(toBeRemoved);
		}
		mapRepository.saveAll(svgs);
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
			plant.getMapSvgTag() == null || plant.getMapSvgTag().size() == 0
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
		
		AssetDTO assetPlant = assetMap.get(originalPlant.getAssetId());
		for(AssetDTO tag: assetPlant.childrens) {
			mapRepository.deleteByIdAsset(tag.assetId);
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
		
		Plant finalPlant = PlantMapper.INSTANCE.plantInDTOToPlant(plant);
		finalPlant.setPlantId(plantId);
		finalPlant.setAssetId(assetId);
		
		plantRepository.save(finalPlant);

		List<MapSvgTagDTO> preSvgs = plant.getMapSvgTag();
		List<MapSvgTag> svgs = new ArrayList<>();
		for(TagDTO tag : plant.getTags()) {
			Integer tagId = assetManager.saveAsset(tag.getName(), tag.getDescription(), typeTagId, workspaceId, assetId, state, null);
			MapSvgTag svg = new MapSvgTag();
			
			List<MapSvgTagDTO> toBeRemoved = new ArrayList<>();
			for(MapSvgTagDTO preSvg : preSvgs) {
				if(preSvg.getTagName().equals(tag.getName())) {
					svg.setIdAsset(tagId);
					svg.setIdSvg(preSvg.getSvgId());
					svg.setTagName(tag.getName());
					svg.setPlant(finalPlant);
					svgs.add(svg);
					toBeRemoved.add(preSvg);
				}
			}
			preSvgs.removeAll(toBeRemoved);
		}
		mapRepository.saveAll(svgs);
		
	}

	@Override
	public void deletePlant(Integer plantId) throws BadRequestDataException {
		Optional<Plant> originalPlantOp = plantRepository.findById(plantId);
		if(originalPlantOp.isEmpty()) {
			throw new BadRequestDataException();
		}
		
		Plant originalPlant = originalPlantOp.get();
		List<AssetDTO> assets = Arrays.asList(assetManager.findByWorkSpace(workspaceId));
		Map<Integer, AssetDTO> assetMap = assets.stream().collect(Collectors.toMap(asset -> asset.assetId, asset -> asset));
		
		AssetDTO assetPlant = assetMap.get(originalPlant.getAssetId());
		for(AssetDTO tag: assetPlant.childrens) {
			assetManager.deletById(tag.assetId);
		}
		assetManager.deletById(assetPlant.assetId);	
		plantRepository.deleteById(plantId);
	}
}
