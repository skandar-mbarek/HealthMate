package com.example.HealthMate.models;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user" ,uniqueConstraints = @UniqueConstraint(columnNames = "email"))
@Builder
public class User implements UserDetails {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "region")
    private String region;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "description")
    private String description;
    @Column( name = "email" , unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private Set<Appointment> doctorAppointments = new HashSet<>();
    @OneToMany(mappedBy = "patient",cascade = CascadeType.ALL)
    private Set<Appointment> patientAppointments = new HashSet<>();



    @Column(name = "created_at")
    @CreationTimestamp
    private Instant createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private Instant updatedAt;








    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        if (role !=null)
        {
            return List.of(new SimpleGrantedAuthority(role.getName()));
        }else return Collections.emptyList();
    }


    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return true;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return true;
    }

    @Override
    public boolean isEnabled()
    {
        return true;
    }
}
