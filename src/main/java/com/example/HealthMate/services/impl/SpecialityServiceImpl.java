package com.example.HealthMate.services.impl;

import com.example.HealthMate.Repositories.SpecialityRepository;
import com.example.HealthMate.models.Speciality;
import com.example.HealthMate.services.SpecialityService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SpecialityServiceImpl implements SpecialityService {

    private final SpecialityRepository specialityRepository;
    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public List<Speciality> getAll() {
        return specialityRepository.findAll();
    }

    @Override
    public Speciality getById(Long id) {
        return specialityRepository.findById(id).orElseThrow();
    }

    @Override
    public Speciality update(Long id, Speciality speciality) {
        Speciality existSpeciality = specialityRepository.findById(id).orElseThrow();
        existSpeciality.setName(existSpeciality.getName());
        return specialityRepository.save(existSpeciality);
    }

    @Override
    public void delete(Long id) {

        specialityRepository.findById(id).orElseThrow();
        specialityRepository.deleteById(id);
    }
}
