package com.example.HealthMate.services;

import com.example.HealthMate.models.Appointment;
import com.example.HealthMate.models.DTO.AppointmentDto;

import java.util.List;

public interface AppointmentService {
    void saveAppointment(Appointment appointment);
    Appointment getAppointmentById(Long id);
    List<AppointmentDto> getAllAppointments();
    List<Appointment> getAppointmentsByDoctorId(Long id);
    List<Appointment> getAppointmentsByDoctorEmail(String email);
    List<Appointment> getAppointmentsByPatientId(Long id);
    List<Appointment> getAppointmentsByPatientEmail(String email);
    Appointment updateAppointment(Appointment appointment,Long id);
    void deleteAppointment(Long id);



}
