package com.example.veterinaria.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "veterinario")
@Data
public class Veterinario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @Column(unique = true, nullable = false)
    private String tarjetaProfesional;

    private String especialidad;

    @Email
    private String correo;

    @ManyToMany(mappedBy = "veterinarios")
    private List<Mascota> mascotas;
}