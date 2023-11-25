package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Schema(description = "TopicInfo Data Transfer Object to use this type of DTO")
public class TopicInfoDTO {

    @Schema(description = "Topic id")
    private Integer id;

    @NotBlank(message = "Description is a required field")
    @Schema(description = "Topic description")
    private String description;

    @NotBlank(message = "Type is a required field")
    @Schema(description = "Topic type")
    private String type;

    @NotBlank(message = "Topic info can not be blank")
    @Schema(description = "Topic info")
    private byte[] info;

    @NotNull(groups = OnCreate.class, message = "Themes cannot be null")
    @Valid
    @Schema(description = "Theme")
    private List<ThemeDTO> themes;
}
