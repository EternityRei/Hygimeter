package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.ThemeDTO;
import com.example.hygimeter.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ThemeMapper {
    ThemeMapper INSTANCE = Mappers.getMapper(ThemeMapper.class);

    Theme toTheme(ThemeDTO themeDTO);
    ThemeDTO toThemeDTO(Theme theme);

    List<Theme> toThemes(List<ThemeDTO> themeDTOS);
    List<ThemeDTO> toThemesDTOS(List<Theme> themes);
}
