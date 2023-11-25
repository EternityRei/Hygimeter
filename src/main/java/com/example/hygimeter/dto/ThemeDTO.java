package com.example.hygimeter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
@Schema(description = "Theme Data Transfer Object")
public class ThemeDTO {

    @Schema(description = "Theme id")
    private Integer id;

    @NotBlank(message = "Title is required field")
    @Schema(description = "Theme title")
    private String title;
}
