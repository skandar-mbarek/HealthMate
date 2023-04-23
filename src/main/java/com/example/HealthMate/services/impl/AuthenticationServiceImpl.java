package com.example.HealthMate.services.impl;

import com.example.HealthMate.Repositories.UserRepository;
import com.example.HealthMate.config.JwtService;
import com.example.HealthMate.models.DTO.AuthenticationRequest;
import com.example.HealthMate.models.DTO.AuthenticationResponse;
import com.example.HealthMate.models.DTO.RegisterRequest;
import com.example.HealthMate.models.User;
import com.example.HealthMate.services.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponse register(RegisterRequest request) {


        User user ;

        if (request.getRole().getId()==1)
        {
            user =  User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .region(request.getRegion())
                    .phoneNumber(request.getPhoneNumber())
                    .description(request.getDescription())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .speciality(request.getSpeciality())
                    .build();

        }else
        {
             user = User.builder()
                    .firstName(request.getFirstName())
                    .lastName(request.getLastName())
                    .region(request.getRegion())
                    .phoneNumber(request.getPhoneNumber())
                    .description(request.getDescription())
                    .email(request.getEmail())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .role(request.getRole())
                    .build();

        }


        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
