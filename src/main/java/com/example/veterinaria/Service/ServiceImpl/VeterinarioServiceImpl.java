package com.example.veterinaria.Service.ServiceImpl;

import com.example.veterinaria.Entity.Veterinario;
import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.Repository.VeterinarioRepository;
import com.example.veterinaria.Service.VeterinarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarioServiceImpl implements VeterinarioService {

    private final VeterinarioRepository veterinarioRepository;

    @Override
    public Veterinario crearVeterinario(Veterinario veterinario) {
        return veterinarioRepository.save(veterinario);
    }

    @Override
    public List<Veterinario> obtenerVeterinarios() {
        return veterinarioRepository.findAll();
    }

    @Override
    public Veterinario obtenerPorId(Long id) {
        return veterinarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con id: " + id));
    }

    @Override
    public Veterinario actualizarVeterinario(Long id, Veterinario veterinario) {
        Veterinario veterinarioExistente = obtenerPorId(id);

        veterinarioExistente.setNombre(veterinario.getNombre());
        veterinarioExistente.setTarjetaProfesional(veterinario.getTarjetaProfesional());
        veterinarioExistente.setEspecialidad(veterinario.getEspecialidad());
        veterinarioExistente.setCorreo(veterinario.getCorreo());

        return veterinarioRepository.save(veterinarioExistente);
    }

    @Override
    public void eliminarVeterinario(Long id) {
        Veterinario veterinarioExistente = obtenerPorId(id);
        veterinarioRepository.delete(veterinarioExistente);
    }
}