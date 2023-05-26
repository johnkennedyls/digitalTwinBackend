package com.icesi.edu.co.pdg.dashboard.model.mappers;

import org.mapstruct.factory.Mappers;
import com.icesi.edu.co.pdg.dashboard.model.dtos.TagDTO;
import icesi.plantapiloto.common.dtos.output.AssetDTO;

public interface AssetMapper {
	AssetMapper INSTANCE = Mappers.getMapper(AssetMapper.class);
	TagDTO assetDTOToTagDTO(AssetDTO assetDto);
}
