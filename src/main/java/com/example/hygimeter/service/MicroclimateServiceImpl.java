package com.example.hygimeter.service;

import com.example.hygimeter.dto.MicroclimateDTO;
import com.example.hygimeter.mapper.MicroclimateMapper;
import com.example.hygimeter.model.Microclimate;
import com.example.hygimeter.repository.MicroclimateRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MicroclimateServiceImpl implements MicroclimateService{

    private final MicroclimateRepository microclimateRepository;
    private final MicroclimateMapper microclimateMapper;

    @Override
    public MicroclimateDTO createMicroclimate(MicroclimateDTO microclimateDTO) {
        Microclimate microclimate = microclimateMapper.toMicroclimate(microclimateDTO);
        return microclimateMapper.toMicroclimateDTO(microclimateRepository.save(microclimate));
    }

    @Override
    public MicroclimateDTO updateMicroclimate(MicroclimateDTO microclimateDTO) {
        Microclimate microclimate = microclimateRepository.findById(microclimateDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Microclimate not found"));

        Microclimate newMicroclimate = microclimateMapper.toMicroclimate(microclimateDTO);
        microclimate.setTemperature(newMicroclimate.getTemperature());
        microclimate.setVentilation(newMicroclimate.getVentilation());
        microclimate.setLightLevel(newMicroclimate.getLightLevel());
        microclimate.setPlan(newMicroclimate.getPlan());
        microclimate.setHumidity(newMicroclimate.getHumidity());
        microclimate.setTemperatureSked(newMicroclimate.getTemperatureSked());
        microclimate.setLightsOffTime(newMicroclimate.getLightsOffTime());

        return microclimateMapper.toMicroclimateDTO(microclimateRepository.save(microclimate));
    }

    @Override
    public void deleteMicroclimate(Integer id) {
        Microclimate microclimate = microclimateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Microclimate not found"));

        microclimateRepository.deleteById(microclimate.getId());
    }

    @Override
    public MicroclimateDTO getMicroclimateById(Integer id) {
        Microclimate microclimate = microclimateRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Microclimate not found"));

        return microclimateMapper.toMicroclimateDTO(microclimate);
    }

    @Override
    public List<MicroclimateDTO> getAllMicroclimates() {
        List<Microclimate> microclimates = microclimateRepository.findAll();
        return microclimateMapper.toMicroclimateDTOS(microclimates);
    }
}
