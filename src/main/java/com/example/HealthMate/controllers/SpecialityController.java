package com.example.HealthMate.controllers;

import com.example.HealthMate.models.Role;
import com.example.HealthMate.models.Speciality;
import com.example.HealthMate.services.RoleService;
import com.example.HealthMate.services.SpecialityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/speciality")
public class SpecialityController {


    private final SpecialityService specialityService;
    @PostMapping
    public ResponseEntity<Speciality> save (@RequestBody @Valid Speciality speciality)
    {
        return  ResponseEntity.ok(specialityService.save(speciality));
    }
    @GetMapping
    public ResponseEntity<List<Speciality>> getAll()
    {
        return ResponseEntity.ok(specialityService.getAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Speciality> getById(@PathVariable(name = "id") long id)
    {
        return ResponseEntity.ok(specialityService.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Speciality> update(@PathVariable(name = "id") long id,@RequestBody @Valid Speciality speciality)
    {
        return ResponseEntity.ok(specialityService.update(id,speciality));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable(name = "id") long id)
    {
        specialityService.delete(id);
        return ResponseEntity.ok("delete success!!");
    }

}
