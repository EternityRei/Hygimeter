package com.example.hygimeter.service;

import com.example.hygimeter.dto.PlanPatternDTO;
import com.example.hygimeter.model.PlanPattern;

import java.util.List;

public interface PlanPatternService {
    PlanPatternDTO createPlanPattern(PlanPatternDTO planPatternDTO);
    PlanPatternDTO updatePlanPattern(Integer id, PlanPatternDTO planPatternDTO);
    void deletePlanPattern(Integer id);
    PlanPattern getPlanPatternById(Integer id);
    List<PlanPattern> getAllPlanPatterns();
}
