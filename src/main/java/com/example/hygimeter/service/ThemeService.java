package com.example.hygimeter.service;

import com.example.hygimeter.dto.ThemeDTO;

import java.util.List;

public interface ThemeService {
    ThemeDTO createTheme(ThemeDTO themeDTO);
    ThemeDTO updateTheme(ThemeDTO themeDTO);
    void deleteTheme(Integer id);
    ThemeDTO getThemeById(Integer id);
    List<ThemeDTO> findAllThemes();
}
