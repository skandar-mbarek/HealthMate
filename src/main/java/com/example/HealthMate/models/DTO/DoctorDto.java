package com.example.HealthMate.models.DTO;

import com.example.HealthMate.models.Role;
import com.example.HealthMate.models.Speciality;
import com.example.HealthMate.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String region;
    private String phoneNumber;
    private String description;
    private String email;
    private Speciality speciality;
    private Role role;

    public  DoctorDto   (User doctor)
    {
        this.id= doctor.getId();
        this.firstName= doctor.getFirstName();
        this.lastName = doctor.getLastName();
        this.region = doctor.getRegion();
        this.phoneNumber = doctor.getPhoneNumber();
        this.description = doctor.getDescription();
        this.email = doctor.getEmail();
        this.speciality = doctor.getSpeciality();
        this.role = doctor.getRole();
    }
    public static List<DoctorDto> make(List<User> users)
    {
        List<DoctorDto> doctorDtos = new ArrayList<>();
        for (User user:users) {
            doctorDtos.add(new DoctorDto(user));
        }
        return doctorDtos;
    }

}
