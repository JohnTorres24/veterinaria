package com.example.veterinaria.Repository;

import com.example.veterinaria.Entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
    // Método personalizado para listar mascotas según el ID del propietario
    List<Mascota> findByPropietarioId(Long propietarioId);
}