package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.HumidityDTO;
import com.example.hygimeter.model.Humidity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface HumidityMapper {
    HumidityMapper INSTANCE = Mappers.getMapper(HumidityMapper.class);

    Humidity toHumidity(HumidityDTO humidityDTO);
    HumidityDTO toHumidityDTO(Humidity humidity);
}
