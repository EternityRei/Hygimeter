package com.example.hygimeter.service;

import com.example.hygimeter.dto.HumidityDTO;

public interface HumidityService {
    HumidityDTO createHumidity(Float relativeHumidity, Float absoluteHumidity);
    HumidityDTO updateHumidity(HumidityDTO humidityDTO);
    void deleteHumidity(Integer id);
    HumidityDTO getHumidityById(Integer id);
}
