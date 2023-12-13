package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Humidity Data Transfer Object")
public class HumidityDTO {

    @Schema(description = "Humidity id")
    private Integer id;

    @Schema(description = "Relative humidity")
    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Relative humidity must be not null and greater than 0")
    @Min(1)
    private Float relativeHumidity;

    @Schema(description = "Absolute humidity")
    @NotNull(groups = {OnCreate.class, OnUpdate.class}, message = "Absolute humidity must be not null and greater than 0")
    @Min(1)
    private Float absoluteHumidity;
}
