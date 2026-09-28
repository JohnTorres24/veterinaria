package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.Veterinario;
import java.util.List;

public interface VeterinarioService {
    Veterinario crearVeterinario(Veterinario veterinario);
    List<Veterinario> obtenerVeterinarios();
    Veterinario obtenerPorId(Long id); // <-- Método para buscar por ID
    Veterinario actualizarVeterinario(Long id, Veterinario veterinario);
    void eliminarVeterinario(Long id);
}