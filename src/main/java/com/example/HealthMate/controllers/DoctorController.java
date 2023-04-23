package com.example.HealthMate.controllers;

import com.example.HealthMate.models.DTO.DoctorDto;
import com.example.HealthMate.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/user/doctor")
public class DoctorController {
    public final UserService userService;


    @GetMapping
    public ResponseEntity<List<DoctorDto>> getAll()
    {
        return ResponseEntity.ok(userService.getAllDoctor());
    }
    @GetMapping("{id}")
    public ResponseEntity<DoctorDto> getRoleById(@PathVariable(name = "id") Long  id)
    {
        return ResponseEntity.ok(userService.getDoctorById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<String> update(@PathVariable(name = "id") Long id,@RequestBody  DoctorDto doctor)
    {
        userService.updateDoctor(id,doctor);
        return ResponseEntity.ok("update success!!");
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") Long id)
    {
        userService.delete(id);
        return ResponseEntity.ok("delete success!!");
    }
}
