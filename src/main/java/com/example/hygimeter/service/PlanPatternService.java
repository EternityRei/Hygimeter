package com.example.hygimeter.service;

import com.example.hygimeter.dto.PlanPatternDTO;

import java.util.List;

public interface PlanPatternService {
    PlanPatternDTO createPlanPattern(PlanPatternDTO planPatternDTO);
    PlanPatternDTO updatePlanPattern(PlanPatternDTO planPatternDTO);
    void deletePlanPattern(Integer id);
    PlanPatternDTO getPlanPatternById(Integer id);
    List<PlanPatternDTO> getAllPlanPatterns();
}
