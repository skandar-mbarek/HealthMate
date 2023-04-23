package com.example.HealthMate.controllers;

import com.example.HealthMate.models.Appointment;
import com.example.HealthMate.models.DTO.AppointmentDto;
import com.example.HealthMate.services.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/appointment")
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<String> saveAppointment(@RequestBody Appointment appointment)
    {
        appointmentService.saveAppointment(appointment);
        return ResponseEntity.ok("save success!!!");
    }
    @GetMapping
    public ResponseEntity<List<AppointmentDto>> getAllAppointments()
    {
        return ResponseEntity.ok(appointmentService.getAllAppointments());
    }
    @GetMapping("{id}")
    public ResponseEntity<Appointment> getAppointmentById(@PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok(appointmentService.getAppointmentById(id));
    }
    @GetMapping("/doctor/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorId(@PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctorId(id));
    }
    @GetMapping("/doctor")
    public ResponseEntity<List<Appointment>> getAppointmentsByDoctorEmail(@RequestParam String email)
    {
        return ResponseEntity.ok(appointmentService.getAppointmentsByDoctorEmail(email));
    }
    @GetMapping("/patient/{id}")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientId(@PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatientId(id));
    }
    @GetMapping("/patient")
    public ResponseEntity<List<Appointment>> getAppointmentsByPatientEmail(@RequestParam String email)
    {
        return ResponseEntity.ok(appointmentService.getAppointmentsByPatientEmail(email));
    }
    @PutMapping("{id}")
    public ResponseEntity<Appointment> updateAppointment(@RequestBody Appointment appointment, @PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok(appointmentService.updateAppointment(appointment,id));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteAppointment(@PathVariable(name = "id") Long id)
    {
        return ResponseEntity.ok("delete success !!");
    }

}
