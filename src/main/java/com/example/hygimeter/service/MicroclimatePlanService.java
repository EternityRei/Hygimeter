package com.example.hygimeter.service;

import com.example.hygimeter.dto.MicroclimatePlanDTO;
import com.example.hygimeter.dto.UserDTO;

import java.util.List;

public interface MicroclimatePlanService {
    MicroclimatePlanDTO createMicroclimatePlan(MicroclimatePlanDTO microclimatePlanDTO);
    MicroclimatePlanDTO updateMicroclimatePlan(Integer id, MicroclimatePlanDTO microclimatePlanDTO);
    void deleteMicroclimatePlan(Integer id);
    MicroclimatePlanDTO getMicroclimatePlanById(Integer id);
    List<MicroclimatePlanDTO> findAllMicroclimatePlans();
    List<MicroclimatePlanDTO> findMicroclimatePlansByUser(UserDTO userDTO);
    MicroclimatePlanDTO findMicroclimatePlanByUser(UserDTO userDTO);
    MicroclimatePlanDTO findMicroclimatePlanById(Integer id);
}
