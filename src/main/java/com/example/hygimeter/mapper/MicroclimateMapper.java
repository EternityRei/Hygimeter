package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.MicroclimateDTO;
import com.example.hygimeter.model.Microclimate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MicroclimateMapper {
    MicroclimateMapper INSTANCE = Mappers.getMapper(MicroclimateMapper.class);

    Microclimate toMicroclimate(MicroclimateDTO microclimateDTO);
    MicroclimateDTO toMicroclimateDTO(Microclimate microclimate);
}
