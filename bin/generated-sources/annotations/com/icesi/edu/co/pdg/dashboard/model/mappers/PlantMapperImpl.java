package com.icesi.edu.co.pdg.dashboard.model.mappers;

import com.icesi.edu.co.pdg.dashboard.model.dtos.in.PlantInDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantListOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.dtos.out.PlantOutDTO;
import com.icesi.edu.co.pdg.dashboard.model.entity.Plant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-29T20:50:51-0500",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 1.4.300.v20221108-0856, environment: Java 17.0.6 (Eclipse Adoptium)"
)
@Component
public class PlantMapperImpl implements PlantMapper {

    @Override
    public Plant plantInDTOToPlant(PlantInDTO plantDto) {
        if ( plantDto == null ) {
            return null;
        }

        Plant plant = new Plant();

        plant.setConventions( plantDto.getConventions() );
        plant.setPlantDescription( plantDto.getPlantDescription() );
        plant.setPlantName( plantDto.getPlantName() );
        plant.setPlantPhoto( plantDto.getPlantPhoto() );
        plant.setSvgImage( plantDto.getSvgImage() );

        return plant;
    }

    @Override
    public PlantOutDTO plantToPlantOutDTO(Plant plant) {
        if ( plant == null ) {
            return null;
        }

        PlantOutDTO plantOutDTO = new PlantOutDTO();

        plantOutDTO.setPlantDescription( plant.getPlantDescription() );
        plantOutDTO.setConventions( plant.getConventions() );
        plantOutDTO.setPlantPhoto( plant.getPlantPhoto() );
        plantOutDTO.setSvgImage( plant.getSvgImage() );
        plantOutDTO.setPlantName( plant.getPlantName() );

        return plantOutDTO;
    }

    @Override
    public PlantListOutDTO plantToPlantListOutDTO(Plant plant) {
        if ( plant == null ) {
            return null;
        }

        PlantListOutDTO plantListOutDTO = new PlantListOutDTO();

        plantListOutDTO.setPlantId( plant.getPlantId() );
        plantListOutDTO.setPlantName( plant.getPlantName() );
        plantListOutDTO.setPlantDescription( plant.getPlantDescription() );
        plantListOutDTO.setPlantPhoto( plant.getPlantPhoto() );
        plantListOutDTO.setAssetId( plant.getAssetId() );

        return plantListOutDTO;
    }
}
