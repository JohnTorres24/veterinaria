package com.example.veterinaria.Service.ServiceImpl;

import com.example.veterinaria.Entity.Mascota;
import com.example.veterinaria.Entity.Veterinario;
import com.example.veterinaria.Exception.ResourceNotFoundException;
import com.example.veterinaria.Repository.MascotaRepository;
import com.example.veterinaria.Repository.VeterinarioRepository;
import com.example.veterinaria.Service.MascotaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MascotaServiceImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;
    private final VeterinarioRepository veterinarioRepository;

    @Override
    public Mascota crearMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> obtenerMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Mascota obtenerPorId(Long id) {
        return mascotaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Mascota no encontrada con id: " + id));
    }

    @Override
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        Mascota mascotaExistente = obtenerPorId(id);

        mascotaExistente.setNombre(mascota.getNombre());
        mascotaExistente.setEspecie(mascota.getEspecie());
        mascotaExistente.setRaza(mascota.getRaza());
        mascotaExistente.setEdad(mascota.getEdad());
        mascotaExistente.setPeso(mascota.getPeso());

        if (mascota.getPropietario() != null) {
            mascotaExistente.setPropietario(mascota.getPropietario());
        }
        if (mascota.getHistoriaClinica() != null) {
            mascotaExistente.setHistoriaClinica(mascota.getHistoriaClinica());
        }

        return mascotaRepository.save(mascotaExistente);
    }

    @Override
    public void eliminarMascota(Long id) {
        Mascota mascotaExistente = obtenerPorId(id);
        mascotaRepository.delete(mascotaExistente);
    }

    @Override
    public List<Mascota> buscarPorPropietario(Long propietarioId) {
        return mascotaRepository.findByPropietarioId(propietarioId);
    }

    @Override
    public Mascota asignarVeterinario(Long mascotaId, Long veterinarioId) {
        Mascota mascota = obtenerPorId(mascotaId);

        Veterinario veterinario = veterinarioRepository.findById(veterinarioId)
                .orElseThrow(() -> new ResourceNotFoundException("Veterinario no encontrado con id: " + veterinarioId));

        if (!mascota.getVeterinarios().contains(veterinario)) {
            mascota.getVeterinarios().add(veterinario);
        }

        return mascotaRepository.save(mascota);
    }
}