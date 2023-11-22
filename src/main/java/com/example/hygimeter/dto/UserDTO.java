package com.example.hygimeter.dto;

import com.example.hygimeter.model.Role;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserDTO {
    private Integer id;
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String name;
    @Pattern(regexp = "^[A-Za-z0-9]+$")
    private String surname;
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$?")
    private String email;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\\\d)(?=.*[@$!%*?&])[A-Za-z\\\\d@$!%*?&]{8,}$")
    private String password;
    private Role role;
}
