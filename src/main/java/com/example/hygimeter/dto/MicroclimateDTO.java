package com.example.hygimeter.dto;

import lombok.Data;

@Data
public class MicroclimateDTO {
    private Integer id;
    private String temperature;
    private String ventilation;
    private Float lightLevel;
    private HumidityDTO humidity;
}
