package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import com.example.hygimeter.model.Microclimate;
import com.example.hygimeter.model.PlanParameters;
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

    @Null(groups = OnCreate.class, message = "Devices must be null at fulling the form")
    @Schema(description = "Plan devices")
    private String device;

    @Null(groups = OnCreate.class, message = "Microclimate should be null while 1st time creating")
    @Valid
    @Schema(description = "Microclimate")
    private MicroclimateDTO microclimateDTO;

    @Null(groups = OnCreate.class, message = "Plan parameters should be null while 1st time creating")
    @Valid
    @Schema(description = "Plan Parameters")
    private PlanParametersDTO planParametersDTO;
}
