package com.example.HealthMate.services;

import com.example.HealthMate.models.DTO.DoctorDto;
import com.example.HealthMate.models.DTO.PatientDto;

import java.util.List;

public interface UserService {

    List<DoctorDto> getAllDoctor();
    DoctorDto getDoctorById(Long id);
    void updateDoctor(Long id, DoctorDto doctor);


    List<PatientDto> getAllPatient();
    PatientDto getPatientById(Long id);
    void updatePatient(Long id, PatientDto patient);
    void delete(Long id);
}
