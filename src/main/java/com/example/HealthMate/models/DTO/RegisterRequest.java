package com.example.HealthMate.models.DTO;

import com.example.HealthMate.models.Role;
import com.example.HealthMate.models.Speciality;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {





    @NotBlank(message = "First name is required")
    private String firstName;
    // todo test git
    @NotBlank(message = "Last name is required")
    private String lastName;
    @NotBlank(message = "region is required")
    private String region;
    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^[0-9]{8}$",message = "phone number not valid")
    private String phoneNumber;
    private String description;
    @NotBlank(message = "email is required")
    @Email(message = "your email is not valid")
    private String email;
    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&.])[A-Za-z\\d@$!%*#?&.]{8,}$",
            message = "The password must contain at least 8 characters, including an uppercase letter, a lowercase letter, a number, and a special symbol.")
    private String password;
    private Role role;
    private Speciality speciality;

    @AssertTrue(message = "Role must be either medecin or patient or admin")
    private boolean isValidRole() {
        if ( role !=null) {
            return role.getId() == 1 || role.getId() == 2 || role.getId() == 3;
        }
        return false;
    }
    @AssertTrue(message = "Speciality must be either Chirurgie générale or Chirurgie pédiatrique or Chirurgie carcinologique if you are doctor ")
    private boolean isValidSpeciality() {
        if (role==null) {
            return true;
        }
        if (role.getId() == 1 && speciality != null &&
                (speciality.getId() == 1 || speciality.getId() == 2 || speciality.getId() == 3))
        {return true;}
        return role.getId() == 2;
    }




}
