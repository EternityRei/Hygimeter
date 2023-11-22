package com.example.hygimeter.mapper;

import com.example.hygimeter.dto.UserDTO;
import com.example.hygimeter.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toUser(UserDTO userDTO);
    UserDTO toUserDTO(User user);
}
