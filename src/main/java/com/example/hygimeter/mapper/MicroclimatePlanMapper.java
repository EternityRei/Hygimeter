package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.MicroclimateDTO;
import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.model.MicroclimatePlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserMapper.class, MicroclimateMapper.class})
public interface MicroclimatePlanMapper {
    MicroclimatePlanMapper INSTANCE = Mappers.getMapper(MicroclimatePlanMapper.class);

    MicroclimatePlan toMicroclimatePlan(MicroclimatePlanDTO microclimatePlanDTO);
    MicroclimatePlanDTO toMicroclimatePlanDTO(MicroclimatePlan microclimatePlan);

    List<MicroclimatePlan> toMicroclimatePlans(List<MicroclimatePlanDTO> microclimateDTOS);
    List<MicroclimatePlanDTO> toMicroclimateDTOS(List<MicroclimatePlan> microclimatePlans);
}
