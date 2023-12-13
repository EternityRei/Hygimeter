package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Schema(description = "Microclimate Data Transfer Object")
public class MicroclimateDTO {

    @Schema(description = "Microclimate id")
    private Integer id;

    @Schema(description = "Microclimate temperature")
    @NotBlank(message = "Temperature is required field")
    @Length(max = 20, message = "Max size of temperature is 20 characters")
    private String temperature;

    @Schema(description = "Microclimate ventilation type")
    @NotBlank(message = "Ventilation is required field")
    @Length(max = 100, message = "Max size of ventilation is 100 characters")
    private String ventilation;

    @Schema(description = "Microclimate ventilation type")
    private Float lightLevel;

    @NotNull(groups = OnCreate.class, message = "Humidity cannot be null")
    @Valid
    @Schema(description = "Humidity")
    private HumidityDTO humidity;

    @Schema(description = "Microclimate temperature schedule")
    @NotBlank(message = "Temperature schedule is required field")
    @Length(max = 100, message = "Max size of temperature schedule is 100 characters")
    private String temperatureSked;

    @Schema(description = "Microclimate lights off time")
    @NotNull(message = "Lights off time is required field")
    private String lightsOffTime;
}
