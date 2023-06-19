package com.icesi.edu.co.pdg.dashboard.services.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icesi.edu.co.pdg.dashboard.exceptions.BadRequestDataException;
import com.icesi.edu.co.pdg.dashboard.exceptions.NoResultException;
import com.icesi.edu.co.pdg.dashboard.model.dtos.MapSvgTagDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.MeasureListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import com.icesi.edu.co.pdg.dashboard.model.entity.MapSvgTag;
import com.icesi.edu.co.pdg.dashboard.model.mappers.PlantMapper;
import com.icesi.edu.co.pdg.dashboard.repositories.MapSvgTagRepository;
import com.icesi.edu.co.pdg.dashboard.repositories.PlantRepository;
import com.icesi.edu.co.pdg.dashboard.services.interfaces.PlantService;

import icesi.plantapiloto.common.controllers.AssetManagerControllerPrx;
import icesi.plantapiloto.common.controllers.MeasurementManagerControllerPrx;
import icesi.plantapiloto.common.dtos.MeasurementDTO;
import icesi.plantapiloto.common.dtos.output.AssetDTO;
import icesi.plantapiloto.common.model.MetaData;

@Service
@Transactional
public class PlantServiceImp implements PlantService {

	@Autowired
	PlantRepository plantRepository;
	@Autowired
	MapSvgTagRepository mapRepository;
	@Autowired
	AssetManagerControllerPrx assetManager;
	@Autowired
	MeasurementManagerControllerPrx measureManager;
	
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
		List<Plant> plants = plantRepository.findAll();
		
		for(Plant plant: plants) {
			AssetDTO asset = assetManager.findById(plant.getAssetId());
			PlantListOutDTO plantOut = PlantMapper.INSTANCE.plantToPlantListOutDTO(plant);
			List<TagDTO> tags = new ArrayList<>();
			for(AssetDTO tag: asset.childrens) {
				TagDTO currentTag = new TagDTO();
				if(tag.state.equals("R")) {
					continue;
				}
				currentTag.setName(tag.name);
				currentTag.setAssetId(tag.assetId);
				currentTag.setDescription(tag.description);
				currentTag.setState(tag.state.charAt(0));
				tags.add(currentTag);
			}
			plantOut.setTags(tags);
			result.add(plantOut);
		}
		
		return result;
	}

	@Override
	public PlantOutDTO getPlantById(Integer id) throws NoResultException {
		Optional<Plant> plantOp = plantRepository.findById(id);
		if(plantOp.isEmpty()) {
			throw new NoResultException();
		}
		Plant plant = plantOp.get();
		
		
		AssetDTO assetPlant = assetManager.findById(plant.getAssetId());
		
		PlantOutDTO result = new PlantOutDTO();
		result.setPlantIp(assetPlant.props.get("plc.ip"));
		result.setPlantSlot(assetPlant.props.get("plc.slot"));
		result.setPlantName(plant.getPlantName());
		result.setPlantPhoto(plant.getPlantPhoto());
		result.setPlantDescription(plant.getPlantDescription());
		result.setConventions(plant.getConventions());
		result.setSvgImage(plant.getSvgImage());
		List<TagDTO> tags = new ArrayList<>();
		for(AssetDTO tag : assetPlant.childrens) {
			TagDTO currentTag = new TagDTO();
			if(tag.state.equals("R")) {
				continue;
			}
			currentTag.setAssetId(tag.assetId);
			currentTag.setDescription(tag.description);
			currentTag.setName(tag.name);
			currentTag.setState(tag.state.charAt(0));
			currentTag.setDataType(tag.props.get("type"));
			tags.add(currentTag);
		}
		List<MapSvgTagDTO> svgs = new ArrayList<>();
		for(MapSvgTag svg :plant.getSvgs()) {
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
			plant.getPlantIp() == null || plant.getPlantIp().isEmpty() || 
			plant.getPlantSlot() == null || plant.getPlantSlot().isEmpty()
		){
			throw new BadRequestDataException();
		}
		
		String name = plant.getPlantName().trim();
		String desc = plant.getPlantDescription();
		String state = "A";
		
		MetaData plantIp = new MetaData();
		plantIp.setName("plc.ip");
		plantIp.setValue(plant.getPlantIp().trim());
		plantIp.setDescription("");
		MetaData plantSlot = new MetaData();
		plantSlot.setName("plc.slot");
		plantSlot.setValue(plant.getPlantSlot().trim());
		plantSlot.setDescription("");
		
		MetaData[] metaDatas = new MetaData[2];
		metaDatas[0] = plantIp;
		metaDatas[1] = plantSlot;
		Integer assetId = assetManager.saveAsset(name, desc, typePlantId, workspaceId, -1, state, metaDatas);
		if(assetId==-1) {
			throw new RuntimeException("Error interno, intente más tarde");
		}
		
		Plant finalPlant = PlantMapper.INSTANCE.plantInDTOToPlant(plant);
		finalPlant.setAssetId(assetId);
		finalPlant = plantRepository.save(finalPlant);
		
		List<MapSvgTagDTO> preSvgs = plant.getMapSvgTag();
		List<MapSvgTag> svgs = new ArrayList<>();
		for(TagDTO tag : plant.getTags()) {
			metaDatas = new MetaData[1];
			MetaData tagType = new MetaData();
			tagType.setName("type");
			tagType.setValue(tag.getDataType());
			metaDatas[0] = tagType;
			Integer tagId = assetManager.saveAsset(tag.getName(), tag.getDescription(), typeTagId, workspaceId, assetId, state, metaDatas);
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
	public void editPlant(PlantInDTO plantDto, Integer plantId) throws BadRequestDataException {
		if(
			plantDto.getPlantName()==null || plantDto.getPlantName().isEmpty() ||
			plantDto.getPlantDescription() == null || plantDto.getPlantDescription().isEmpty() ||
			plantDto.getSvgImage() == null || plantDto.getSvgImage().isEmpty() || 
			plantDto.getTags() == null || plantDto.getTags().size() == 0 
		){
			throw new BadRequestDataException();
		}
		
		Optional<Plant> originalPlantOp = plantRepository.findById(plantId);
		if(originalPlantOp.isEmpty()) {
			throw new BadRequestDataException();
		}
		String state = "A";
		
		Plant plant = originalPlantOp.get();
		
		HashMap<String,String> mapProps = new HashMap<String,String>();
		mapProps.put("plc.ip", plantDto.getPlantIp().trim());
		mapProps.put("plc.slot", plantDto.getPlantSlot().trim());
		
		AssetDTO assetPlant = assetManager.findById(plant.getAssetId());
		
		assetPlant.props = mapProps;
		
		String name = plant.getPlantName().trim();
		String desc = plant.getPlantDescription();
		assetPlant.name = name;
		assetPlant.description = desc;
		assetManager.updateAsset(assetPlant);
		
		Plant finalPlant = PlantMapper.INSTANCE.plantInDTOToPlant(plantDto);
		finalPlant.setPlantId(plantId);
		finalPlant.setAssetId(assetPlant.assetId);
		finalPlant = plantRepository.save(finalPlant);

		List<MapSvgTagDTO> preSvgs = plantDto.getMapSvgTag();
		List<MapSvgTag> svgs = new ArrayList<>();
		mapRepository.deleteAllByPlant(finalPlant);
		for(TagDTO tag : plantDto.getTags()) {
			Integer tagId = -1;
			if(tag.getAssetId()==null) {
				tagId = assetManager.saveAsset(tag.getName(), tag.getDescription(), typeTagId, workspaceId, assetPlant.assetId, state, null);
			}else {
				AssetDTO oldTag = assetManager.findById(tag.getAssetId());
				oldTag.name = tag.getName();
				oldTag.description = tag.getDescription();
				oldTag.state = tag.getState().toString();
				assetManager.updateAsset(oldTag);
				tagId = oldTag.assetId;
			}
			
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
		
		Plant plant = originalPlantOp.get();
		
		AssetDTO assetPlant = assetManager.findById(plant.getAssetId());
		plantRepository.deleteById(plantId);
		for(AssetDTO tag: assetPlant.childrens) {
			assetManager.deletById(tag.assetId);
		}
		assetManager.deletById(assetPlant.assetId);	
		
	}
	
	@Override
	public List<MeasureListOutDTO> getTagValuesByStartAndEndDate(Integer plantId, Long startDate, Long endDate) throws BadRequestDataException {
		Optional<Plant> plantOp = plantRepository.findById(plantId);
		if(plantOp.isEmpty()) {
			throw new BadRequestDataException();
		}
		Plant plant = plantOp.get();
		List<MeasureListOutDTO> measures = new ArrayList<>();
		AssetDTO[] assetList = assetManager.findByWorkSpace(workspaceId);
		AssetDTO asset = new AssetDTO();
		for(AssetDTO cAsset : assetList) {
			if(cAsset.assetId==plant.getAssetId()) {
				asset = cAsset;
				break;
			}
		}
		for(AssetDTO cAsset : asset.childrens) {
			MeasurementDTO[] currentMeasures = measureManager.getMeasurments(cAsset.assetId, startDate, endDate);
			MeasureListOutDTO measure = new MeasureListOutDTO();
			measure.setAssetId(cAsset.assetId);
			measure.setMeasures(currentMeasures);
			measures.add(measure);
		}
		return measures;
	}
}
