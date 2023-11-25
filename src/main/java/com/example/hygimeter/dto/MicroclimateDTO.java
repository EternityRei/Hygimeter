package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Microclimate Data Transfer Object")
public class MicroclimateDTO {

    @Schema(description = "Microclimate id")
    private Integer id;

    @Schema(description = "Microclimate temperature")
    @NotNull(message = "Temperature is required field")
    private String temperature;

    @Schema(description = "Microclimate ventilation type")
    @NotNull(message = "Ventilation is required field")
    private String ventilation;

    @Schema(description = "Microclimate ventilation type")
    private Float lightLevel;

    @NotNull(groups = OnCreate.class, message = "Humidity cannot be null")
    @Valid
    @Schema(description = "Humidity")
    private HumidityDTO humidity;
}
