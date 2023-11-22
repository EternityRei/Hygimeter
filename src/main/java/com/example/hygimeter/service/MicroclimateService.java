package com.example.hygimeter.service;

import com.example.hygimeter.dto.MicroclimateDTO;

import java.util.List;

public interface MicroclimateService {
    MicroclimateDTO createMicroclimate(MicroclimateDTO microclimateDTO);
    MicroclimateDTO updateMicroclimate(MicroclimateDTO microclimateDTO);
    void deleteMicroclimate(Integer id);
    MicroclimateDTO getMicroclimateById(Integer id);
    List<MicroclimateDTO> getAllMicroclimates();
}
