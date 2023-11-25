package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import com.example.hygimeter.model.Microclimate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
@Schema(description = "Plan Pattern Data Transfer Object")
public class PlanPatternDTO {

    @Schema(description = "PlanPattern id")
    private Integer id;

    @NotNull(groups = OnUpdate.class, message = "Devices must be specified at plan")
    @Null(groups = OnCreate.class, message = "Devices must be null at fulling the form")
    @Schema(description = "Plan devices")
    private String device;

    @NotNull(groups = OnCreate.class, message = "Microclimate cannot be null")
    @Valid
    @Schema(description = "Microclimate")
    private Microclimate microclimate;

    @NotNull(groups = OnCreate.class, message = "Plan parameters cannot be null")
    @Valid
    @Schema(description = "Plan Parameters")
    private PlanParametersDTO planParameters;
}
