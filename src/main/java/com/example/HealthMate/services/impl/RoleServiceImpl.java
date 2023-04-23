package com.example.HealthMate.services.impl;

import com.example.HealthMate.Repositories.RoleRepository;
import com.example.HealthMate.models.Role;
import com.example.HealthMate.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role getById(Long id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Role update(Long id, Role role) {
        Role existRole = roleRepository.findById(id).orElseThrow();
        existRole.setName(existRole.getName());
        return roleRepository.save(existRole);
    }

    @Override
    public void delete(Long id) {
        roleRepository.findById(id).orElseThrow();
        roleRepository.deleteById(id);
    }
}
