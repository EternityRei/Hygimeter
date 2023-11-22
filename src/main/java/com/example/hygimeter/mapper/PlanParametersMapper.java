package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.PlanParametersDTO;
import com.example.hygimeter.model.PlanParameters;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PlanParametersMapper {
    PlanParametersMapper INSTANCE = Mappers.getMapper(PlanParametersMapper.class);

    PlanParameters toPlanParameters(PlanParametersDTO planParametersDTO);
    PlanParametersDTO toPlanParametersDTO(PlanParameters planParameters);
}
