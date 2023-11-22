package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.PlanPatternDTO;
import com.example.hygimeter.model.PlanPattern;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = PlanParametersMapper.class)
public interface PlanPatternMapper {
    PlanPatternMapper INSTANCE = Mappers.getMapper(PlanPatternMapper.class);

    PlanPattern toPlanPattern(PlanPatternDTO planPatternDTO);
    PlanPatternDTO toPlanPatternDTO(PlanPattern planPattern);
}
