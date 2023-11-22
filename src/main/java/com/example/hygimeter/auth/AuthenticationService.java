package com.example.hygimeter.auth;

import com.example.hygimeter.config.JwtService;
import com.example.hygimeter.exception.EntityNotFoundException;
import com.example.hygimeter.model.User;
import com.example.hygimeter.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.hygimeter.exception.ErrorCode.INVALID_PASSWORD;
import static com.example.hygimeter.exception.ErrorCode.IRRELEVANT_EMAIL;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail())
                .orElseThrow(() -> new EntityNotFoundException(IRRELEVANT_EMAIL.name(), "This user does not exist"));

        if (!(passwordEncoder.matches(request.getPassword(), user.getPassword()))) {
            throw new EntityNotFoundException(INVALID_PASSWORD.name(), "Wrong password. Please try again");
        }

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        String jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .build();
    }

}
