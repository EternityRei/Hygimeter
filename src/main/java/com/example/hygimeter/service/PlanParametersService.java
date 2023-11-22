package com.example.hygimeter.service;

import com.example.hygimeter.dto.PlanParametersDTO;

public interface PlanParametersService {
    PlanParametersDTO createPlanParameters(PlanParametersDTO planParametersDTO);
    PlanParametersDTO updatePlanParameters(PlanParametersDTO planParametersDTO);
    void deletePlanParameters(Integer id);
    PlanParametersDTO getPlanParametersById(Integer id);
}
