package com.example.HealthMate.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="specialities")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;

    @NotBlank(message = "The name is required.")
    private String name;
    private String description;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant UpdatedAt;
}
