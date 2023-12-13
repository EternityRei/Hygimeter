package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
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

    @Schema(description = "Plan Parameters temperature schedule")
    @Null(groups = OnCreate.class, message = "Temperature schedule must be null on creating plan parameters")
    @NotBlank(groups = OnUpdate.class, message = "Temperature schedule must be not null and not empty on updating parameters")
    @Length(max = 100, message = "Max size of temperature schedule is 100 characters")
    private String temperatureSked;

    @Schema(description = "Plan Parameters time when lights go off")
    @Null(groups = OnCreate.class, message = "Time when lights go off must be null on creating plan parameters")
    @NotNull(groups = OnUpdate.class, message = "Time when lights go off must be not null on updating parameters")
    private LocalTime lightsOffTime;
}
