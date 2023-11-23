package com.example.hygimeter.service;

import com.example.hygimeter.dto.PlanPatternDTO;
import com.example.hygimeter.mapper.PlanPatternMapper;
import com.example.hygimeter.model.PlanPattern;
import com.example.hygimeter.repository.PlanPatternRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanPatternServiceImpl implements PlanPatternService{

    private final PlanPatternRepository planPatternRepository;
    private final PlanPatternMapper planPatternMapper;

    @Override
    public PlanPatternDTO createPlanPattern(PlanPatternDTO planPatternDTO) {
        PlanPattern planPattern = planPatternMapper.toPlanPattern(planPatternDTO);
        return planPatternMapper.toPlanPatternDTO(planPatternRepository.save(planPattern));
    }

    @Override
    public PlanPatternDTO updatePlanPattern(PlanPatternDTO planPatternDTO) {
        PlanPattern planPattern = planPatternRepository.findById(planPatternDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Humidity not found"));

        PlanPattern newPlanPattern = planPatternMapper.toPlanPattern(planPatternDTO);
        planPattern.setMicroclimatePlans(newPlanPattern.getMicroclimatePlans());
        planPattern.setDevice(newPlanPattern.getDevice());
        planPattern.setPlanParameters(newPlanPattern.getPlanParameters());

        return planPatternMapper.toPlanPatternDTO(planPatternRepository.save(planPattern));
    }

    @Override
    public void deletePlanPattern(Integer id) {
        PlanPattern planPattern = planPatternRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Humidity not found"));

        planPatternRepository.deleteById(id);
    }

    @Override
    public PlanPatternDTO getPlanPatternById(Integer id) {
        PlanPattern planPattern = planPatternRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Humidity not found"));

        return planPatternMapper.toPlanPatternDTO(planPatternRepository.save(planPattern));
    }

    @Override
    public List<PlanPatternDTO> getAllPlanPatterns() {
        List<PlanPattern> planPatterns = planPatternRepository.findAll();
        return planPatternMapper.toPlanPatternDTOS(planPatterns);
    }
}
