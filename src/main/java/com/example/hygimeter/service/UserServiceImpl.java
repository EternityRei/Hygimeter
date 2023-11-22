package com.example.hygimeter.service;

import com.example.hygimeter.dto.UserDTO;
import com.example.hygimeter.exception.EntityNotFoundException;
import com.example.hygimeter.exception.ErrorCode;
import com.example.hygimeter.mapper.UserMapper;
import com.example.hygimeter.model.User;
import com.example.hygimeter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    //private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO register(UserDTO userDTO) {
        checkEmailIsUnique(userDTO.getEmail());
        User user = userMapper.toUser(userDTO);
        //user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    private void checkEmailIsUnique(String email){
        if (userRepository.existsByEmail(email)){
            throw new EntityNotFoundException(ErrorCode.DUPLICATE_EMAIL.name(), "This email is already exist");
        }
    }
}
