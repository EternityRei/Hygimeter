package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.dto.group.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalTime;

@Data
@Schema(description = "Plan Parameters Data Transfer Object")
public class PlanParametersDTO {

    @Schema(description = "Plan Parameters id")
    private Integer id;

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
