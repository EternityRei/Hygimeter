package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "Humidity Data Transfer Object")
public class HumidityDTO {

    @Schema(description = "Humidity id")
    private Integer id;

    @Schema(description = "Relative humidity")
    @Null(groups = OnCreate.class, message = "Relative humidity must be null on creating plan parameters")
    @NotNull(groups = OnUpdate.class, message = "Relative humidity must be not null on updating parameters")
    private Float relativeHumidity;

    @Schema(description = "Absolute humidity")
    @Null(groups = OnCreate.class, message = "Absolute humidity must be null on creating plan parameters")
    @NotNull(groups = OnUpdate.class, message = "Absolute humidity must be not null on updating parameters")
    private Float absoluteHumidity;
}
