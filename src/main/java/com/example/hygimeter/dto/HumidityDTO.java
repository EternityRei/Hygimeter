package com.example.hygimeter.dto;

import lombok.Data;

@Data
public class HumidityDTO {
    private Integer id;
    private Float relativeHumidity;
    private Float absoluteHumidity;
}
