package com.example.hygimeter.service;

import com.example.hygimeter.dto.HumidityDTO;
import com.example.hygimeter.mapper.HumidityMapper;
import com.example.hygimeter.model.Humidity;
import com.example.hygimeter.repository.HumidityRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HumidityServiceImpl implements HumidityService{

    private final HumidityRepository humidityRepository;
    private final HumidityMapper humidityMapper;

    @Override
    public HumidityDTO createHumidity(HumidityDTO humidityDTO) {
        Humidity humidity = humidityMapper.toHumidity(humidityDTO);
        return humidityMapper.toHumidityDTO(humidityRepository.save(humidity));
    }

    @Override
    public HumidityDTO updateHumidity(HumidityDTO humidityDTO) {
        Humidity existingHumidity = humidityRepository.findById(humidityDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Humidity not found"));

        Humidity newHumidity = humidityMapper.toHumidity(humidityDTO);
        existingHumidity.setAbsoluteHumidity(newHumidity.getAbsoluteHumidity());
        existingHumidity.setRelativeHumidity(newHumidity.getRelativeHumidity());

        return humidityMapper.toHumidityDTO(humidityRepository.save(existingHumidity));
    }

    @Override
    public void deleteHumidity(Integer id) {
        if (!humidityRepository.existsById(id)) {
            throw new EntityNotFoundException("Humidity not found");
        }
        humidityRepository.deleteById(id);
    }

    @Override
    public HumidityDTO getHumidityById(Integer id) {
        Humidity humidity = humidityRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Humidity not found"));

        return humidityMapper.toHumidityDTO(humidity);
    }
}
