package com.example.hygimeter.service;

import com.example.hygimeter.dto.MicroclimateDTO;
import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.dto.PlanPatternDTO;
import com.example.hygimeter.dto.UserDTO;

import java.util.List;

public interface MicroclimatePlanService {
    MicroclimatePlanDTO createMicroclimatePlan(PlanPatternDTO planPatternDTO, UserDTO userDTO, MicroclimateDTO initialMicroclimateDTO);
    MicroclimatePlanDTO updateMicroclimatePlan(MicroclimatePlanDTO microclimatePlanDTO);
    void deleteMicroclimatePlan(Integer id);
    MicroclimatePlanDTO getMicroclimatePlanById(Integer id);
    List<MicroclimatePlanDTO> findAllMicroclimatePlans();
    List<MicroclimatePlanDTO> findMicroclimatePlansByUser(UserDTO userDTO);
    MicroclimatePlanDTO findMicroclimatePlanById(Integer id);
}
