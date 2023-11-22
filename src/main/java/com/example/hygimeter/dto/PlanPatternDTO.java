package com.example.hygimeter.dto;

import lombok.Data;

@Data
public class PlanPatternDTO {
    private Integer id;
    private String device;
    private PlanParametersDTO planParameters;
}
