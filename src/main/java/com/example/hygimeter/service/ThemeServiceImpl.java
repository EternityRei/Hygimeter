package com.example.hygimeter.service;

import com.example.hygimeter.dto.ThemeDTO;
import com.example.hygimeter.mapper.ThemeMapper;
import com.example.hygimeter.model.Humidity;
import com.example.hygimeter.model.Theme;
import com.example.hygimeter.repository.ThemeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ThemeServiceImpl implements ThemeService{

    private final ThemeRepository themeRepository;
    private final ThemeMapper themeMapper;

    @Override
    public ThemeDTO createTheme(ThemeDTO themeDTO) {
        Theme theme = themeMapper.toTheme(themeDTO);
        return themeMapper.toThemeDTO(themeRepository.save(theme));
    }

    @Override
    public ThemeDTO updateTheme(ThemeDTO themeDTO) {
        Theme existingTheme = themeRepository.findById(themeDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Theme not found"));

        Theme newTheme = themeMapper.toTheme(themeDTO);

        existingTheme.setTitle(newTheme.getTitle());
        existingTheme.setTopicInfos(newTheme.getTopicInfos());

        return themeMapper.toThemeDTO(themeRepository.save(existingTheme));
    }

    @Override
    public void deleteTheme(Integer id) {
        if (!themeRepository.existsById(id)) {
            throw new EntityNotFoundException("Theme not found");
        }
        themeRepository.deleteById(id);
    }

    @Override
    public ThemeDTO getThemeById(Integer id) {
        Theme theme = themeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Humidity not found"));

        return themeMapper.toThemeDTO(theme);
    }

    @Override
    public List<ThemeDTO> findAllThemes() {
        List<Theme> themes = themeRepository.findAll();
        return themeMapper.toThemesDTOS(themes);
    }
}
