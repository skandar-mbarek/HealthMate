package com.example.HealthMate.config;

import com.example.HealthMate.models.Role;
import com.example.HealthMate.models.Speciality;
import com.example.HealthMate.services.RoleService;
import com.example.HealthMate.services.SpecialityService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class StartUpApp implements CommandLineRunner {

    private final RoleService roleService;
    private final SpecialityService specialityService;


    @Override
    public void run(String... args) throws Exception {

        if (roleService.getAll().isEmpty())
        {
            List<String> roles = Arrays.asList( "doctor","patient","admin");
            roles.forEach(role->{
                Role newRole = new Role();
                newRole.setName(role);
                roleService.save(newRole);
            });

        }
        if (specialityService.getAll().isEmpty())
        {
            specialityService.save(new  Speciality(null,"Chirurgie générale","sddqsdqsd",null,null));
            specialityService.save(new  Speciality(null,"Chirurgie pédiatrique","sddqsdqsd",null,null));
            specialityService.save(new  Speciality(null,"Chirurgie carcinologique","sddqsdqsd",null,null));
        }


    }
}
