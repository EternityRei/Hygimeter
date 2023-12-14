package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import com.example.hygimeter.dto.types.VentilationType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalTime;

@Data
@Schema(description = "Microclimate Data Transfer Object")
public class MicroclimateDTO {

    @Schema(description = "Microclimate id")
    private Integer id;

    @Schema(description = "Microclimate temperature")
    @NotBlank(message = "Temperature.java is required field")
    @Length(max = 20, message = "Max size of temperature is 20 characters")
    private String temperature;

    @Schema(description = "Microclimate ventilation type")
    @NotNull(message = "Ventilation is required field")
    private VentilationType ventilation;

    @Schema(description = "Microclimate ventilation type")
    private Float lightLevel;

    @NotNull(groups = OnCreate.class, message = "Humidity cannot be null")
    @Valid
    @Schema(description = "Humidity")
    private HumidityDTO humidity;

    @Schema(description = "Plan Parameters time when lights go off")
    @Null(groups = OnCreate.class, message = "Time when lights go off must be null on creating plan parameters")
    @NotNull(groups = OnUpdate.class, message = "Time when lights go off must be not null on updating parameters")
    private LocalTime lightsOffTime;
}

