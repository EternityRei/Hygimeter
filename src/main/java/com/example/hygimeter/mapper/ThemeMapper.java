package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.ThemeDTO;
import com.example.hygimeter.model.Theme;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ThemeMapper {
    ThemeMapper INSTANCE = Mappers.getMapper(ThemeMapper.class);

    Theme toTheme(ThemeDTO themeDTO);
    ThemeDTO toThemeDTO(Theme theme);
}
