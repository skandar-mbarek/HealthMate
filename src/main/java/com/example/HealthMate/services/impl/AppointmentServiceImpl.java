package com.example.HealthMate.services.impl;

import com.example.HealthMate.Repositories.AppointmentRepository;
import com.example.HealthMate.Repositories.UserRepository;
import com.example.HealthMate.exceptions.InvalidRoleException;
import com.example.HealthMate.models.Appointment;
import com.example.HealthMate.models.DTO.AppointmentDto;
import com.example.HealthMate.models.DTO.DoctorDto;
import com.example.HealthMate.models.DTO.PatientDto;
import com.example.HealthMate.models.User;
import com.example.HealthMate.services.AppointmentService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final UserRepository userRepository;
    private final AppointmentRepository appointmentRepository;
    @Override
    public void saveAppointment(@NotNull Appointment appointment) {
        User doctor = userRepository.findById(appointment.getDoctor().getId()).orElseThrow();
        User patient = userRepository.findByEmail(appointment.getPatient().getEmail()).orElseThrow();



        if (doctor.getRole().getId()!=1){
            throw new InvalidRoleException("The specified doctor is not valid.");
        }
        if (patient.getRole().getId()!=2){
            throw new InvalidRoleException("The specified patient is not valid.");
        }

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElseThrow();
    }

    @Override
    public List<AppointmentDto> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll() ;
        List<AppointmentDto> appointmentsDto = new ArrayList<>();
        for (Appointment appointment:appointments) {


            AppointmentDto appointmentDto = AppointmentDto.builder()
                    .id(appointment.getId())
                    .appointmentDate(appointment.getAppointmentDate())
                    .status(appointment.getStatus())
                    .doctor(new  DoctorDto(appointment.getDoctor()))
                    .build();
            appointmentsDto.add(appointmentDto);
        }
        return appointmentsDto;
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorId(Long id) {
        return appointmentRepository.findAllByDoctorId(id);
    }

    @Override
    public List<Appointment> getAppointmentsByDoctorEmail(String email) {
        return appointmentRepository.findAllByDoctorEmail(email);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientId(Long id) {
        return appointmentRepository.findAllByPatientId(id);
    }

    @Override
    public List<Appointment> getAppointmentsByPatientEmail(String email) {
        return appointmentRepository.findAllByPatientEmail(email);
    }

    @Override
    public Appointment updateAppointment(Appointment appointment, Long id) {
        Appointment existAppointment= appointmentRepository.findById(id).orElseThrow();
        existAppointment.setDoctor(appointment.getDoctor());
        existAppointment.setPatient(appointment.getPatient());
        existAppointment.setAppointmentDate(appointment.getAppointmentDate());
        existAppointment.setStatus(appointment.getStatus());

        return appointmentRepository.save(existAppointment);
    }
    @Override
    public void deleteAppointment(Long id) {
        appointmentRepository.findById(id).orElseThrow();
        appointmentRepository.deleteById(id);
    }
}
