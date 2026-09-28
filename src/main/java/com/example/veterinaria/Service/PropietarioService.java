package com.example.veterinaria.Service;

import com.example.veterinaria.Entity.Propietario;
import java.util.List;

public interface PropietarioService {
    Propietario crearPropietario(Propietario propietario);
    List<Propietario> obtenerPropietarios();
    Propietario obtenerPorId(Long id);
    Propietario actualizarPropietario(Long id, Propietario propietario);
    void eliminarPropietario(Long id);
}