package com.example.HealthMate.services.impl;

import com.example.HealthMate.Repositories.UserRepository;
import com.example.HealthMate.models.DTO.DoctorDto;
import com.example.HealthMate.models.DTO.PatientDto;
import com.example.HealthMate.models.User;
import com.example.HealthMate.services.UserService;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class UserServerImpl implements UserService {
    
    private final UserRepository userRepository;
    
    @Override
    public List<DoctorDto> getAllDoctor()
    {
        List<User> users = userRepository.findAll() ;
        List<DoctorDto> doctors = new ArrayList<>();
        for (User user:users)
        {
            if (user.getRole().getId()==2){
                continue;
            }

            DoctorDto doctor = DoctorDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .region(user.getRegion())
                    .phoneNumber(user.getPhoneNumber())
                    .description(user.getDescription())
                    .email(user.getEmail())
                    .speciality(user.getSpeciality())
                    .role(user.getRole())
                    .build();
            doctors.add(doctor);
        }
        return doctors;
    }

    @Override
    public DoctorDto getDoctorById(Long id)
    {
        User user = userRepository.findById(id).orElseThrow() ;
        return DoctorDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .region(user.getRegion())
                .phoneNumber(user.getPhoneNumber())
                .description(user.getDescription())
                .email(user.getEmail())
                .speciality(user.getSpeciality())
                .role(user.getRole())
                .build();
    }

    @Override
    public void updateDoctor(Long id, DoctorDto doctor)
    {
        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(doctor.getFirstName());
        user.setLastName(doctor.getLastName());
        user.setRegion(doctor.getRegion());
        user.setPhoneNumber(doctor.getPhoneNumber());
        user.setDescription(doctor.getDescription());
        user.setEmail(doctor.getEmail());
        user.setSpeciality(doctor.getSpeciality());

        userRepository.save(user);

    }



    @Override
    public List<PatientDto> getAllPatient()
    {
        List<User> users = userRepository.findAll() ;
        List<PatientDto> patients = new ArrayList<>();
        for (User user:users)
        {
            if (user.getRole().getId()==1){
                continue;
            }

            PatientDto patient = PatientDto.builder()
                    .id(user.getId())
                    .firstName(user.getFirstName())
                    .lastName(user.getLastName())
                    .region(user.getRegion())
                    .phoneNumber(user.getPhoneNumber())
                    .description(user.getDescription())
                    .email(user.getEmail())
                    .role(user.getRole())
                    .build();
            patients.add(patient);
        }
        return patients;
    }

    @Override
    public PatientDto getPatientById(Long id)
    {
        User user = userRepository.findById(id).orElseThrow() ;
        return PatientDto.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .region(user.getRegion())
                .phoneNumber(user.getPhoneNumber())
                .description(user.getDescription())
                .email(user.getEmail())
                .build();
    }

    @Override
    public void updatePatient(Long id, PatientDto patient)
    {

        User user = userRepository.findById(id).orElseThrow();
        user.setFirstName(patient.getFirstName());
        user.setLastName(patient.getLastName());
        user.setRegion(patient.getRegion());
        user.setPhoneNumber(patient.getPhoneNumber());
        user.setDescription(patient.getDescription());
        user.setEmail(patient.getEmail());


        userRepository.save(user);
    }

    @Override
    public void delete(Long id)
    {
        userRepository.findById(id).orElseThrow();
        userRepository.deleteById(id);
    }
}
