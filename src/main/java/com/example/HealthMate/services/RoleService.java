package com.example.HealthMate.services;

import com.example.HealthMate.models.Role;

import java.util.List;


public interface RoleService {
    Role save(Role role);
    List<Role> getAll();
    Role getById(Long id);
    Role update(Long id, Role role);
    void delete(Long id);
}
