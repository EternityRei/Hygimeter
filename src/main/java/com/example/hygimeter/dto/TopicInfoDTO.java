package com.example.hygimeter.dto;

import lombok.Data;

import java.util.List;

@Data
public class TopicInfoDTO {

    private Integer id;
    private String description;
    private String type;
    private byte[] info;
    private List<ThemeDTO> themes;
}
