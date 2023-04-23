package com.example.HealthMate.Repositories;

import com.example.HealthMate.models.Appointment;
import com.example.HealthMate.models.DTO.AppointmentDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
    List<Appointment> findAllByDoctorId(Long doctorId);
    List<Appointment> findAllByDoctorEmail(String email);
    List<Appointment> findAllByPatientId(Long patientId);
    List<Appointment> findAllByPatientEmail(String email);

}
