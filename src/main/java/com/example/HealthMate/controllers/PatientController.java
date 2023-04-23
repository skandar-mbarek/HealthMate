package com.example.HealthMate.controllers;



import com.example.HealthMate.models.DTO.PatientDto;
import com.example.HealthMate.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user/patient")
public class PatientController {
    public final UserService userService;


    @GetMapping
    public ResponseEntity<List<PatientDto>> getAll()
    {
        return ResponseEntity.ok(userService.getAllPatient());
    }
    @GetMapping("{id}")
    public ResponseEntity<PatientDto> getRoleById(@PathVariable(name = "id") Long  id)
    {
        return ResponseEntity.ok(userService.getPatientById(id));
    }


    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id,@RequestBody PatientDto patient)
    {
        userService.updatePatient(id,patient);
        return ResponseEntity.ok("update success!!");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id)
    {
        userService.delete(id);
        return ResponseEntity.ok("delete success!!");
    }


}
