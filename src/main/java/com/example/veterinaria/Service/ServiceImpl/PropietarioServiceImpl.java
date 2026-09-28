package com.example.veterinaria.Service.ServiceImpl;

import com.example.veterinaria.Entity.Propietario;
import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.Repository.PropietarioRepository;
import com.example.veterinaria.Service.PropietarioService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PropietarioServiceImpl implements PropietarioService {

    private final PropietarioRepository propietarioRepository;

    @Override
    public Propietario crearPropietario(Propietario propietario) {
        return propietarioRepository.save(propietario);
    }

    @Override
    public List<Propietario> obtenerPropietarios() {
        return propietarioRepository.findAll();
    }

    @Override
    public Propietario obtenerPorId(Long id) {
        return propietarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Propietario no encontrado con id: " + id));
    }

    @Override
    public Propietario actualizarPropietario(Long id, Propietario propietario) {
        Propietario propietarioExistente = obtenerPorId(id);

        propietarioExistente.setNombre(propietario.getNombre());
        propietarioExistente.setDocumento(propietario.getDocumento());
        propietarioExistente.setTelefono(propietario.getTelefono());
        propietarioExistente.setCorreo(propietario.getCorreo());

        return propietarioRepository.save(propietarioExistente);
    }

    @Override
    public void eliminarPropietario(Long id) {
        Propietario propietarioExistente = obtenerPorId(id);
        propietarioRepository.delete(propietarioExistente);
    }
}