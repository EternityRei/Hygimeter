package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Schema(description = "Microclimate Plan Data Transfer Object")
public class MicroclimatePlanDTO {

    @Schema(description = "Microclimate Plan id")
    private Integer id;

    @NotNull(groups = OnCreate.class, message = "Plan pattern cannot be null")
    @Valid
    @Schema(description = "Plan Pattern")
    private PlanPatternDTO planPattern;

    @NotNull(groups = OnCreate.class, message = "Initial Microclimate cannot be null")
    @Valid
    @Schema(description = "Microclimate")
    private MicroclimateDTO initialMicroclimate;

    @NotNull(groups = OnCreate.class, message = "User cannot be null")
    @Valid
    @Schema(description = "User")
    private UserDTO user;

    @NotNull(groups = OnCreate.class, message = "Topic cannot be null")
    @Valid
    @Schema(description = "Topic Info")
    private TopicInfoDTO topic;
}
