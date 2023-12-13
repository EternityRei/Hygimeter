package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.UserDTO;
import com.example.hygimeter.service.UserService;

public class UserMapperContext {

    private final UserService userService;

    public UserMapperContext(UserService userService) {
        this.userService = userService;
    }

    public UserDTO getUserById(Integer id) {
        return id != null ? userService.getUserById(id) : null;
    }
}