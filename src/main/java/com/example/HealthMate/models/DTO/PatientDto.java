package com.example.HealthMate.models.DTO;

import com.example.HealthMate.models.Role;
import com.example.HealthMate.models.Speciality;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String region;
    private String phoneNumber;
    private String description;
    private String email;
    private String password;
    private Role role;

}
