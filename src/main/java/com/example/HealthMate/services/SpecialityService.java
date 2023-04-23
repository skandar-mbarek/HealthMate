package com.example.HealthMate.services;

import com.example.HealthMate.models.Speciality;

import java.util.List;

public interface SpecialityService {
    Speciality save(Speciality speciality);
    List<Speciality> getAll();
    Speciality getById(Long id);
    Speciality update(Long id, Speciality speciality);
    void delete(Long id);
}
