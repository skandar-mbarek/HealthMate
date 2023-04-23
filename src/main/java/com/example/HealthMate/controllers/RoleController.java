package com.example.HealthMate.controllers;

import com.example.HealthMate.models.Role;
import com.example.HealthMate.services.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/role")

public class RoleController {


    private final RoleService roleService;
    @PostMapping
    public ResponseEntity<Role> save (@RequestBody  Role role)
    {
        return  ResponseEntity.ok(roleService.save(role));
    }
    @GetMapping
    public ResponseEntity<List<Role>> getAllRoles()
    {
        return ResponseEntity.ok(roleService.getAll());
    }
    @GetMapping("{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable(name = "id") Long  id)
    {
        return ResponseEntity.ok(roleService.getById(id));
    }
    @PutMapping("{id}")
    public ResponseEntity<Role> updateRole(@PathVariable(name = "id") Long id,@RequestBody  Role role)
    {
        return ResponseEntity.ok(roleService.update(id,role));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteRole(@PathVariable(name = "id") Long id)
    {
        roleService.delete(id);
        return ResponseEntity.ok("delete success!!");
    }

}
