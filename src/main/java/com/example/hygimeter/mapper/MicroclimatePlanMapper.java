package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.model.MicroclimatePlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapper.class, TopicInfoMapper.class, MicroclimateMapper.class, PlanPatternMapper.class})
public interface MicroclimatePlanMapper {
    MicroclimatePlanMapper INSTANCE = Mappers.getMapper(MicroclimatePlanMapper.class);

    MicroclimatePlan toMicroclimatePlan(MicroclimatePlanDTO microclimatePlanDTO);
    MicroclimatePlanDTO toMicroclimatePlanDTO(MicroclimatePlan microclimatePlan);
}
