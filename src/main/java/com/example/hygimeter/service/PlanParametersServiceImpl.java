package com.example.hygimeter.service;

import com.example.hygimeter.dto.PlanParametersDTO;
import com.example.hygimeter.mapper.PlanParametersMapper;
import com.example.hygimeter.model.PlanParameters;
import com.example.hygimeter.repository.PlanParametersRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanParametersServiceImpl implements PlanParametersService{

    private final PlanParametersRepository planParametersRepository;
    private final PlanParametersMapper planParametersMapper;

    @Override
    public PlanParametersDTO createPlanParameters(PlanParametersDTO planParametersDTO) {
        PlanParameters planParameters = planParametersMapper.toPlanParameters(planParametersDTO);
        return planParametersMapper.toPlanParametersDTO(planParametersRepository.save(planParameters));
    }

    @Override
    public PlanParametersDTO updatePlanParameters(PlanParametersDTO planParametersDTO) {
        PlanParameters planParameters = planParametersRepository.findById(planParametersDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Plan parameters not found"));

        PlanParameters newPlanParameters = planParametersMapper.toPlanParameters(planParametersDTO);
        planParameters.setTemperatureSked(newPlanParameters.getTemperatureSked());
        planParameters.setLightsOffTime(newPlanParameters.getLightsOffTime());

        return planParametersMapper.toPlanParametersDTO(planParametersRepository.save(planParameters));
    }

    @Override
    public void deletePlanParameters(Integer id) {
        PlanParameters planParameters = planParametersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan parameters not found"));

        planParametersRepository.deleteById(id);
    }

    @Override
    public PlanParametersDTO getPlanParametersById(Integer id) {
        PlanParameters planParameters = planParametersRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plan parameters not found"));

        return planParametersMapper.toPlanParametersDTO(planParameters);
    }
}
