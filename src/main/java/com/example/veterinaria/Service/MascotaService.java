package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.Mascota;
import java.util.List;

public interface MascotaService {
    Mascota crearMascota(Mascota mascota);
    List<Mascota> obtenerMascotas();
    Mascota obtenerPorId(Long id);
    Mascota actualizarMascota(Long id, Mascota mascota);
    void eliminarMascota(Long id);

    // Métodos adicionales requeridos
    List<Mascota> buscarPorPropietario(Long propietarioId);
    Mascota asignarVeterinario(Long mascotaId, Long veterinarioId);
}