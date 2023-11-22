package com.example.hygimeter.dto;

import lombok.Data;

@Data
public class MicroclimatePlanDTO {
    private Integer id;
    private PlanPatternDTO planPattern;
    private MicroclimateDTO initialMicroclimate;
    private UserDTO user;
    private TopicInfoDTO topic;
}
