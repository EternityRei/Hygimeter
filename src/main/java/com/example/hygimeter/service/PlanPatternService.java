package com.example.hygimeter.service;

import com.example.hygimeter.dto.PlanPatternDTO;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

public interface PlanPatternService {
    PlanPatternDTO createPlanPattern(PlanPatternDTO planPatternDTO);
    PlanPatternDTO updatePlanPattern(Integer id, PlanPatternDTO planPatternDTO);
    void deletePlanPattern(Integer id);
    PlanPatternDTO getPlanPatternById(Integer id);
    List<PlanPatternDTO> getAllPlanPatterns();
}
