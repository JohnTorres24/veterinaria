package com.example.veterinaria.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "mascota")
@Data
public class Mascota {

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    private String especie;
    private String raza;
    private Integer edad;
    private Double peso;

    // Le decimos a Jackson que solo tome en cuenta el ID del propietario e ignore el resto de atributos
    @ManyToOne
    @JoinColumn(name = "propietario_id")
    @JsonIgnoreProperties({"nombre", "documento", "telefono", "correo", "mascotas"})
    private Propietario propietario;

    @Schema(hidden = true)
    @OneToOne(mappedBy = "mascota", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("mascota")
    private HistoriaClinica historiaClinica;

    @Schema(hidden = true)
    @ManyToMany
    @JoinTable(
            name = "mascota_veterinario",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns = @JoinColumn(name = "veterinario_id")
    )
    @JsonIgnoreProperties({"mascotas", "veterinarios"})
    private List<Veterinario> veterinarios;
}