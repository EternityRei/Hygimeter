package com.example.hygimeter.dto;

import com.example.hygimeter.dto.group.OnCreate;
import com.example.hygimeter.model.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(description = "User Data Transfer Object, specify role:USER to use this type of DTO")
public class UserDTO {
    @Schema(description = "User id")
    private Integer id;

    @NotBlank(message = "Name is required field")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Name must contain only characters and numbers")
    @Schema(description = "User name", required = true)
    private String name;

    @NotBlank(message = "Surname is required field")
    @Pattern(regexp = "^[A-Za-z0-9]+$", message = "Surname must contain only characters and numbers")
    @Schema(description = "User surname", required = true)
    private String surname;

    @NotBlank(message = "Email is required field")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$?", message = "Email must contain @ and . symbols")
    @Schema(description = "User email", required = true)
    private String email;

    @NotBlank(groups = OnCreate.class, message = "Password is required field")
    @Pattern(regexp = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$", message = "Password must contain at least 8 characters, " +
            "upper and lower case letters, numbers and special characters")
    @Schema(description = "User password", required = true)
    private String password;

    @Schema(description = "User role")
    private Role role;
}
