package com.example.HealthMate.services;

import com.example.HealthMate.models.DTO.AuthenticationRequest;
import com.example.HealthMate.models.DTO.AuthenticationResponse;
import com.example.HealthMate.models.DTO.RegisterRequest;
import org.springframework.stereotype.Service;


public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
