package com.example.hygimeter.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class PlanParametersDTO {
    private Integer id;
    private String temperatureSked;
    private LocalTime lightsOffTime;
}
