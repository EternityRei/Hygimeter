package com.example.hygimeter.service;

import com.example.hygimeter.dto.UserDTO;

public interface UserService {
    UserDTO register(UserDTO userDTO);

    UserDTO updateUser(String email, UserDTO userDTO);

    UserDTO getUserByEmail(String email);
    UserDTO getUserById(Integer id);
}
