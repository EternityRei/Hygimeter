package com.example.hygimeter.service;

import com.example.hygimeter.dto.UserDTO;
import com.example.hygimeter.exception.EntityNotFoundException;
import com.example.hygimeter.exception.StatusCodes;
import com.example.hygimeter.mapper.UserMapper;
import com.example.hygimeter.model.User;
import com.example.hygimeter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.hygimeter.exception.StatusCodes.ENTITY_NOT_FOUND;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDTO register(UserDTO userDTO) {
        checkEmailIsUnique(userDTO.getEmail());
        User user = userMapper.toUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepository.save(user);
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO updateUser(String email, UserDTO userDTO) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(ENTITY_NOT_FOUND.name(), "User not found"));

        User newUser = userMapper.toUser(userDTO);

        user.setName(newUser.getName());
        user.setSurname(newUser.getSurname());
        user.setEmail(newUser.getEmail());
        user.setRole(newUser.getRole());

        return userMapper.toUserDTO(userRepository.save(user));
    }

    private void checkEmailIsUnique(String email){
        if (userRepository.existsByEmail(email)){
            throw new EntityNotFoundException(StatusCodes.DUPLICATE_EMAIL.name(), "This email is already exist");
        }
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findUserByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(StatusCodes.USER_NOT_FOUND.name(), "User not found"));
        return userMapper.toUserDTO(user);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(StatusCodes.USER_NOT_FOUND.name(), "User not found"));
        return userMapper.toUserDTO(user);
    }
}
